var user_Role={
	/**
	 * 放数据
	 * */
		data:{
			user:{
				username:"",
				uid:""
			},
			checkedStr:"",
			zTreeplugin:""
		},
		/**
		 * 存放操作
		 * */
		opt:{
			//div操作
			divOpt:{
				show:function(){
					$("div:hidden").show();
				}
			},
			//用户操作
			userOpt:{
				showName:function(){
					$("#userImage").text("用户名："+user_Role.data.user.username);
				}
			},
			//角色树操作
			roleTree:{
			    setting:{
			    		isSimpleData: true,
			    		treeNodeKey: "rid",
			    		treeNodeParentKey: "pid",
			    		showLine: true,
			    		checkable:true,
			    		root:{ 
			    			isRoot:true,
			    			nodes:[]
			    		}
			        },
			        //加载角色树
			        loadRoleTree:function(){
			        	$.post("roleAction_showRoleTree.action",null,function(data){
			        		user_Role.data.zTreeplugin = $("#roleTree").zTree(user_Role.opt.roleTree.setting,data);
			        		
			        	});
			        },
			        //得到选中的nodes
			        getSelectNodesIds:function(){
			        	var nodes = user_Role.data.zTreeplugin.getCheckedNodes();
			        	var str = "";
			        	for(var i=0;i<nodes.length;i++){
			        		if(i==nodes.length-1){
			        			str = str+nodes[i].rid;
			        		}else{
			        			str = str+nodes[i].rid+"_";
			        		}
			        	}
			        	user_Role.data.checkedStr = str;
			        },
			        //保存user-role关系
			        saveUser_Role:function(){
			        	$("#saveRole").css("cursor", "pointer")
			        	$("#saveRole").unbind("click")
			        	$("#saveRole").bind("click",function(){
			        		user_Role.opt.roleTree.getSelectNodesIds();
			        		var param={
			        			uid:user_Role.data.user.uid,
			        			rids:user_Role.data.checkedStr
			        		};
			        		$.post("roleAction_saveUserRole.action",param,function(){
			        			alert("保存成功")
			        		});
			        	})
			        },
			        //回显角色树
			        roleTreeEcho:function(){
			        	var uid = user_Role.data.user.uid;
			        	
			        	$.post("roleAction_userRoleEcho.action?uid="+uid,null,function(data){
			        		setTimeout(function(){
			        			
			        			user_Role.data.zTreeplugin = $("#roleTree").zTree(user_Role.opt.roleTree.setting,data);
			        		},500);
			        	});
			        }
			        
			    	
			}
		},
		/**
		 * 初始化
		 * */
		init:{
			initData:function(){
				var username = $(this).parent().siblings("td:first").text();
				var uid =  $(this).parent().siblings("input[type='hidden']").attr("value");
				user_Role.data.user.username=username;
				user_Role.data.user.uid=uid;
			},
			initEvent:function(){
				$("a").each(function(){
					$(this).css("cursor", "pointer")
					if($(this).text="选择角色"){
						$(this).unbind("click");
						$(this).bind("click",function(){
							//显示username
							user_Role.init.initData.call(this)
							user_Role.opt.userOpt.showName();
							//显示div
							user_Role.opt.divOpt.show();
							//加载角色树
							user_Role.opt.roleTree.loadRoleTree();
							$("#loading").hide();
							//对角色原有权限回显
							user_Role.opt.roleTree.roleTreeEcho();
						});
						$("#allchecked").unbind("click");
						$("#allchecked").bind("click",function(){
							if($(this).attr("checked")){
								user_Role.data.zTreeplugin.checkAllNodes(true);
							}else{
								user_Role.data.zTreeplugin.checkAllNodes(false);
							}
						});
					}
				});
				
			}
		}
}
$().ready(function(){
	user_Role.init.initEvent();
	user_Role.opt.roleTree.saveUser_Role();
});