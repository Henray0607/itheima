var user_Role={
	/**
	 * 放数据
	 * */
		data:{
			user:{
				name:"",
				rid:""
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
			//角色操作
			roleOpt:{
				showName:function(){
					$("#roleImage").text("角色名："+user_Role.data.role.name);
				}
			},
			//权限树操作
			privilegeTree:{
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
			        loadPrivilegeTree:function(){
			        	$.post("privilegeAction_showPrivilegeTree.action",null,function(data){
			        		
			        		user_Role.data.zTreeplugin = $("#privilegeTree").zTree(user_Role.opt.privilegeTree.setting,data);
			        	});
			        },
			        getSelectNodesIds:function(){
			        	var nodes = user_Role.data.zTreeplugin.getCheckedNodes();
			        	var str="";
			        	for(var i=0;i<nodes.length;i++){
			        		if(i==nodes.length-1){
			        			str = str+nodes[i].id;
			        		}else{
			        			str = str+nodes[i].id+"_";
			        		}
			        		
			        	}
			        	user_Role.data.checkedStr=str;
			        },
			        saveuser_Role:function(){
			        	user_Role.opt.privilegeTree.getSelectNodesIds();
			        	var param={
			        			rid:user_Role.data.role.rid,
			        			ids:user_Role.data.checkedStr,
			        	};
			        	$.post("privilegeAction_saveuser_Role.action",param,function(data){
			        		alert("success");
			        	});
			        },
			        privilegeTreeEcho:function(){
			        	var rid = user_Role.data.role.rid
			        	$.post("privilegeAction_privilegeEcho.action?rid="+rid,null,function(data){
			        		 user_Role.data.zTreeplugin = $("#privilegeTree").zTree(user_Role.opt.privilegeTree.setting,data);
			        		
			        	});
			        	
			        }
			        
			    	
			}
		},
		/**
		 * 初始化
		 * */
		init:{
			initData:function(){
				var name = $(this).parent().siblings("td:first").text();
				var rid =  $(this).parent().siblings("input[type='hidden']").attr("value");
				user_Role.data.role.name=name;
				user_Role.data.role.rid=rid;
			},
			initEvent:function(){
				$("a").each(function(){
					$(this).css("cursor", "pointer")
					if($(this).text="选择角色"){
						$(this).unbind("click");
						$(this).bind("click",function(){
							//显示div
							//加载权限树
							//
							//对角色原有权限回显
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
	$("#savePrivilege").css("cursor", "pointer")
	$("#savePrivilege").unbind("click");
	$("#savePrivilege").bind("click",function(){
		user_Role.opt.privilegeTree.saveuser_Role();
	});
});