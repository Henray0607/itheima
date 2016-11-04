var roleTree={
	/**
	 * 放数据
	 * */
		data:{
			treeNode:'',
			zTreePlugin:''
		},
		setting:{
			isSimpleData: true,
			treeNodeKey: "mid",
			treeNodeParentKey: "pid",
			showLine: true,
			root:{ 
				isRoot:true,
				nodes:[]
			},
			
			callback:{

				rightClick:function(event,treeId,treeNode){
					roleTree.showRmenu(event.clientX, event.clientY);
					roleTree.data.treeNode = treeNode;
				}
			}
		},
		/**
		 * 显示右键菜单
		 * 
		 * */
		showRmenu: function(x,y){
			$("#contextMenu ul").show();
			$("#contextMenu").css({"top":y+"px","left":x+"px","display":"block"});
		},
		
		loadRoleTree: function(){
			$.post("roleAction_showRoleTree.action",null,function(data){
				roleTree.data.zTreePlugin = $("#zTree").zTree(roleTree.setting,data);
			});
		},
		init:{
			initEvent:function(){
				$("#addRole").unbind("click");
				$("#addRole").bind("click",function(){
					var roleName = window.prompt();
					var treeNode = roleTree.data.treeNode;
					
					if(roleName){
						var param = {
							name:roleName,
							pid:treeNode,
							isParent:false
						};
						$().post("roleAction_addRole.action",param,function(data){
							alert(data.rid);
							var newtreeNode ={
								rid:data.rid,
								name:roleName,
								pid:roleTree.data.treeNode.rid,
								isParent:false
							} ;
							roleTree.data.zTreePlugin.addNode(roleTree.data.treeNode,newtreeNode,true);
						});
					}
				});
			}
		}
		
};

$().ready(function(){
	roleTree.loadRoleTree();
	/*$("#contextMenu").hover(function(){
		//进入该区域的事件
		
	},function(){
		setTimeout(function(){$("#contextMenu").hide()},500)
	});*/
	roleTree.init.initEvent();
});