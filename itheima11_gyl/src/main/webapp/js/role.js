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
			treeNodeKey: "rid",
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
				//增加子节点
				$("#addRole").unbind("click");
				$("#addRole").bind("click",function(){
					var roleName = window.prompt();
					var treeNode = roleTree.data.treeNode;
					if(roleName){
						var param = {
							name:roleName,
							pid:treeNode.rid,
							isParent:false
						};
						$.post("roleAction_addRole.action",param,function(data){
							var newtreeNode ={
								rid:data.rid,
								name:roleName,
								pid:roleTree.data.treeNode.rid,
								isParent:false
							} ;
							roleTree.data.zTreePlugin.addNodes(roleTree.data.treeNode,newtreeNode,true);
						});
					}
				});
				//删除节点
				$("#deleteRole").unbind("click");
				$("#deleteRole").bind("click",function(){
					var node = roleTree.data.treeNode;
					if(node.isParent){//判断是否为父节点
						//是附节点
						var flag = window.confirm("您删除的是父节点!确定删除吗？");
						if(flag){
							$.post("roleAction_deleteParentNode.action?rid="+node.rid,null,function(){
								roleTree.data.zTreePlugin.removeNode(node);
							});	
						}						
					}else{
						//不是父节点
						$.post("roleAction_deleteRole.action?rid="+node.rid,null,function(){
							roleTree.data.zTreePlugin.removeNode(node);
						});
					}
					$("#contextMenu").hide();
				});
				//修改
				$("#updateRole").unbind("click");
				$("#updateRole").bind("click",function(){
					$("#contextMenu").hide();
					var name = window.prompt("name","");
					var data={
						rid:roleTree.data.treeNode.rid,
						name:name
					};
					if(name){
						$.post("roleAction_updateRole.action",data,function(data){
						/*	var newtreeNode ={
									rid:1,
									name:data.name,
									pid:0,
									isParent:true
							} ;*/
							
							var node = roleTree.data.treeNode;
							node.name=data.name;
							roleTree.data.zTreePlugin.updateNode(node,true);
							
						});
					}
				});
				
			}
		}
		
};

$().ready(function(){
	roleTree.loadRoleTree();
	$("#contextMenu").hover(function(){
		//进入该区域的事件
		
	},function(){
		setTimeout(function(){$("#contextMenu").hide()},500)
	});
	roleTree.init.initEvent();
});