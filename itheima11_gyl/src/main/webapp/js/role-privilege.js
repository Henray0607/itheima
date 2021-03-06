var rolePrivilege={
	/**
	 * 放数据
	 * */
		data:{
			role:{
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
					$("#roleImage").text("角色名："+rolePrivilege.data.role.name);
				}
			},
			//权限树操作
			privilegeTree:{
			    setting:{
			    		isSimpleData: true,
			    		treeNodeKey: "id",
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
			        		
			        		rolePrivilege.data.zTreeplugin = $("#privilegeTree").zTree(rolePrivilege.opt.privilegeTree.setting,data);
			        	});
			        },
			        getSelectNodesIds:function(){
			        	var nodes = rolePrivilege.data.zTreeplugin.getCheckedNodes();
			        	var str="";
			        	for(var i=0;i<nodes.length;i++){
			        		if(i==nodes.length-1){
			        			str = str+nodes[i].id;
			        		}else{
			        			str = str+nodes[i].id+"_";
			        		}
			        		
			        	}
			        	rolePrivilege.data.checkedStr=str;
			        },
			        saveRolePrivilege:function(){
			        	rolePrivilege.opt.privilegeTree.getSelectNodesIds();
			        	var param={
			        			rid:rolePrivilege.data.role.rid,
			        			ids:rolePrivilege.data.checkedStr,
			        	};
			        	$.post("privilegeAction_saveRolePrivilege.action",param,function(data){
			        		alert("success");
			        	});
			        },
			        privilegeTreeEcho:function(){
			        	var rid = rolePrivilege.data.role.rid
			        	$.post("privilegeAction_privilegeEcho.action?rid="+rid,null,function(data){
			        		 rolePrivilege.data.zTreeplugin = $("#privilegeTree").zTree(rolePrivilege.opt.privilegeTree.setting,data);
			        		
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
				rolePrivilege.data.role.name=name;
				rolePrivilege.data.role.rid=rid;
			},
			initEvent:function(){
				$("a").each(function(){
					$(this).css("cursor", "pointer")
					if($(this).text="设置权限"){
						$(this).unbind("click");
						$(this).bind("click",function(){
							//显示div
							rolePrivilege.opt.divOpt.show();
							rolePrivilege.init.initData.call(this);
							//加载权限树
							rolePrivilege.opt.roleOpt.showName();
							$("#loading").hide();
							rolePrivilege.opt.privilegeTree.loadPrivilegeTree();
							//
							//对角色原有权限回显
							rolePrivilege.opt.privilegeTree.privilegeTreeEcho();
						});
						$("#allchecked").unbind("click");
						$("#allchecked").bind("click",function(){
							if($(this).attr("checked")){
								rolePrivilege.data.zTreeplugin.checkAllNodes(true);
							}else{
								rolePrivilege.data.zTreeplugin.checkAllNodes(false);
							}
						});
					}
				});
				
			}
		}
}
$().ready(function(){
	rolePrivilege.init.initEvent();
	$("#savePrivilege").css("cursor", "pointer")
	$("#savePrivilege").unbind("click");
	$("#savePrivilege").bind("click",function(){
		rolePrivilege.opt.privilegeTree.saveRolePrivilege();
	});
});