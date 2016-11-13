/**
 *  该js的任务就是动态的填充一个表格
 */
(function($){
	$.fn.GridPanel = {
		/**
		 * 默认的参数的配置
		 */
		defaultConfig:{
			url:'',
			data:'',
			fields:'' //代表表格中有多少列
		},
		/**
		 * 创建表格
		 */
		createTable:function(config){
			/**
			 * 把config中的内容赋值到$.fn.GridPanel.defaultConfig
			 */
			$.extend($.fn.GridPanel.defaultConfig,config);
			$.post($.fn.GridPanel.defaultConfig.url,null,function(data){
				/**
				 * data就是服务器传递到前台的数据
				 * data = [
				 * 		{pid:1,spbm:'',spmc:'',shulv:'',dw:'',xh:''},
				 * 		{pid:1,spbm:'',spmc:'',shulv:'',dw:'',xh:''},
				 * 		{pid:1,spbm:'',spmc:'',shulv:'',dw:'',xh:''}
				 * ];
				 */
				$.fn.GridPanel.createTR(data);
				
				
			});
		},
		/**
		 * 创建tr
		 */
		createTR:function(data){
			$.each(data,function(){//循环行
				var row = this;//this代表{pid:1,spbm:'',spmc:'',shulv:'',dw:'',xh:''}
				var $tr = $("<tr/>");
				var fields = $.fn.GridPanel.defaultConfig.fields;
				$.each(fields,function(){//循环列
					var $td = $.fn.GridPanel.createTD(this,row);//this为fields的每一个元素：每一列
					$tr.append($td);
				});
				
				$("#seek table").append($tr);
			});
		},
		/**
		 * 创建td
		 * field = <td width="500" item="spmc">商品名称</td>
		 */
		createTD:function(field,row){
			/**
			 * row:{pid:1,spbm:'',spmc:'',shulv:'',dw:'',xh:''}
			 * row[$(field).attr("item")]==row['spmc']
			 */
			if($(field).attr("item")=="radio"){
				var $radio = $("<input/>").attr("type","radio");
				return $("<td/>").attr("item",$(field).attr("item")).append($radio);
			}else{
				return $("<td/>").attr("item",$(field).attr("item")).text(row[$(field).attr("item")]);	
			}
		}
	};
})($);
