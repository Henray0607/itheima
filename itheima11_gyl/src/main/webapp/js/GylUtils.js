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
					
				});
				
				$("input[flag='nextPage']").unbind("click");
				$("input[flag='nextPage']").bind("click",function(){
					GylUtils.basedata.dispage.linkNextPage.call(this);
				});
				
				$("input[flag='lastPage']").unbind("click");
				$("input[flag='lastPage']").bind("click",function(){
					
				});
			}
		},
			
			
		/**
		 * 权限模块
		 */
		
		/**
		 * 业务模块
		 */
};