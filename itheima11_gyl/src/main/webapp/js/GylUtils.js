var GylUtils = {
		/**
		 * 基础数据模块
		 */
		basedata:{
			/**
			 *分页逻辑
			 */
			dispage:{
				/**
				 * 
				 */
				linkNextPage:function(){
					var currentPage = $(this).attr("param");
					var totalPages = $("body").data("totalPages");
					
					if(currentPage>=totalPages){
						currentPage=totalPages;
					}else if(currentPage<=1){
						currentPage=1;
					}
					var url= $("body").data("url");
					window.location.href=url+"?currentPage="+currentPage;
				}
			},
			
			/**
			 * 初始化事件
			 * */
			initEvent:function(){
				$("input[flag='firstPage']").unbind("click");
				$("input[flag='firstPage']").bind("click",function(){
					GylUtils.basedata.dispage.linkNextPage.call(this);
				});
				$("input[flag='prePage']").unbind("click");
				$("input[flag='prePage']").bind("click",function(){
					GylUtils.basedata.dispage.linkNextPage.call(this)
				});
				
				$("input[flag='nextPage']").unbind("click");
				$("input[flag='nextPage']").bind("click",function(){
					GylUtils.basedata.dispage.linkNextPage.call(this);
				});
				
				$("input[flag='lastPage']").unbind("click");
				$("input[flag='lastPage']").bind("click",function(){
					GylUtils.basedata.dispage.linkNextPage.call(this);
				});
				
				$("#controlCheckbox").click(function(){
					var checkButtons = $("input[name='ids']");
					if($("#controlCheckbox").attr("checked")==true){
						
						for (var i = 0; i < checkButtons.length; i++) {
							checkButtons[i].checked=true;
						}
					}else{
						for (var i = 0; i < checkButtons.length; i++) {
							checkButtons[i].checked=false;
					}
				}
				});
				$("#deleteSome").click(function(){
					var checkButtons = $("input[name='ids']");
					var s ="";
					for (var i = 0; i < checkButtons.length; i++) {
						
						if(checkButtons[i].checked){
							if(i!=checkButtons.length-1){
								s = s+checkButtons[i].value+"_";
							}else{
								s = s+checkButtons[i].value;
							}
						};
					}
					alert(s);
					window.location.href="departmentAction_deleteDepartmentByIds.action?ids="+s;
				});
			}
		},
			
			
		/**
		 * 权限模块
		 */
		
		
		
		/**
		 * 业务模块
		 */
		//GylUtils.business.disPage.zhubDispageEvent();
		business_xsydd:{
			
			dispage:{
				/**
				 * 
				 */
				linkNextPage:function(){
					var currentPage = $(this).attr("param");
					var totalPages = $("body").data("totalPages");
					
					if(currentPage>=totalPages){
						currentPage=totalPages;
					}else if(currentPage<=1){
						currentPage=1;
					}
					
					var url= $("body").data("url");
				//	xsyddAction_showXsydd.action?query_zhib.xsyddzhubid=
					window.location.href=url+"?xsyddzhubQuery.currentPage="+currentPage;
					
				},
				linkNextPage_zi:function(){
					var currentPage = $(this).attr("param");
					alert("currentPage_web"+currentPage)
					var totalPages = $("body").data("totalPages");
					
					if(currentPage>=totalPages){
						currentPage=totalPages;
					}else if(currentPage<=1){
						currentPage=1;
					}
					
					var url= $("body").data("url");
				//	xsyddAction_showXsydd.action?query_zhib.xsyddzhubid=
					window.location.href=url+"?xsyddzhibQuery.currentPage="+currentPage;
					
				},
				pageDisplay:{
				
					zhubDisplay:function(){

						$("input[flag='zhub_firstPage']").unbind("click");
						$("input[flag='zhub_firstPage']").bind("click",function(){
							GylUtils.business_xsydd.dispage.linkNextPage.call(this);
						});
						$("input[flag='zhub_prePage']").unbind("click");
						$("input[flag='zhub_prePage']").bind("click",function(){
							GylUtils.business_xsydd.dispage.linkNextPage.call(this)
						});
						
						$("input[flag='zhub_nextPage']").unbind("click");
						$("input[flag='zhub_nextPage']").bind("click",function(){
							GylUtils.business_xsydd.dispage.linkNextPage.call(this)
						});
						
						$("input[flag='zhub_lastPage']").unbind("click");
						$("input[flag='zhub_lastPage']").bind("click",function(){
							GylUtils.business_xsydd.dispage.linkNextPage.call(this)
						});
						
					},
					zhibDisplay:function(){
						$("input[flag='zhib_firstPage']").unbind("click");
						$("input[flag='zhib_firstPage']").bind("click",function(){
							GylUtils.business_xsydd.dispage.linkNextPage_zi.call(this);
						});
						$("input[flag='zhib_prePage']").unbind("click");
						$("input[flag='zhib_prePage']").bind("click",function(){
							GylUtils.business_xsydd.dispage.linkNextPage_zi.call(this);
						});
						
						$("input[flag='zhib_nextPage']").unbind("click");
						$("input[flag='zhib_nextPage']").bind("click",function(){
							GylUtils.business_xsydd.dispage.linkNextPage_zi.call(this);
						});
						
						$("input[flag='zhib_lastPage']").unbind("click");
						$("input[flag='zhib_lastPage']").bind("click",function(){
							GylUtils.business_xsydd.dispage.linkNextPage_zi.call(this);
						});
					}
				},
				
			},
			initEvent:function(){
				GylUtils.business_xsydd.dispage.pageDisplay.zhubDisplay();
				GylUtils.business_xsydd.dispage.pageDisplay.zhibDisplay();
			}
			
		}
		
		
};
