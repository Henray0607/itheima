<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/gyl/common/common.jsp"%>
<link type="text/css" rel="stylesheet" href="css/style_customer.css"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<!--
    jquery日期样式的导入
-->
<link rel="stylesheet" href="js/jquery.datepick.css" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}js/jquery-1.4.2.js"></script>
<script type="text/javascript" src="js/jquery.datepick.js"></script>
<script type="text/javascript" src="js/jquery.datepick-zh-CN.js"></script>
<script type="text/javascript">
var baseData={
	hanghao:1
}

function allclose(){
	$("#seek").hide();
}
function addTD(){
	$.post("getAllProduct.action",null,function(data){
        var id="product_"
           $.each(data, function(i,product) {
        	   
        	   var tr ="<tr><td width='500' item='radio'><input type='checkbox' name='productPid' value='"+product.pid+"'/></td><td width='500' item='spmc' >"+product.spmc+"</td><td width='300' item='xh'>"+product.xh+"</td><td width='300' item='spbm'>"+product.spbm+"</td><td width='300' item='dw'>"+product.dw+"</td><td width='300' item='shulv'>"+product.shulv+"</td></tr>" ;
        	   $("#product_table").append(tr);
           });
        
    });
}
function getAllCheckedbox(){
	var checkButtons = $("input[name='productPid']");
	var pids ="";
	for (var i = 0; i < checkButtons.length; i++) {
		
		if(checkButtons[i].checked){
			if(i!=checkButtons.length-1){
				pids = pids+checkButtons[i].value+"_";
			}else{
				pids = pids+checkButtons[i].value;
			}
		};
	}
	return pids;
}
function callBack_product(){
	$("#seek").hide();
	alert("ajax callback")
	var pidss = getAllCheckedbox();
	var param={
		pids:pidss
	}
	$.post("getProductByIds.action",param,function(data){
		//回显商品
		callBack(data);
	});
};
function callBack(data){
	$.each(data, function(i,product) {
		var hanghao = baseData.hanghao;
		baseData.hanghao=hanghao+1;
		var ii=hanghao-1;
		var tr="<tr align='center'>"+
				"<td width='30' field='hh'><input type='text' readonly=’readonly‘ name='xsddzhibs["+ii+"].hh' value='"+hanghao+"'/></td>"+
				"<td width='100' field='spmc'><input type='text' readonly=’readonly‘ name='xsddzhibs["+ii+"].spmc' value='"+product.spmc+"'/></td>"+
			   "<td width='75' field='spbm'><input type='text' readonly=’readonly‘ name='xsddzhibs["+ii+"].spbm'/>"+product.spbm+"</td>"+
			   "<td width='75' field='xh'><input type='text' readonly=’readonly‘ name='xsddzhibs["+ii+"].xh'/>"+product.xh+"</td>"+
			   "<td width='50' field='dw'><input type='text' readonly=’readonly‘ name='xsddzhibs["+ii+"].dw'/>"+product.dw+"</td>"+
			   "<td width='75' field='sl'><input type='text' name='xsddzhibs["+ii+"].sl'/></td>"+
			   "<td width='75' field='shulv'><input type='text' readonly=’readonly‘ name='xsddzhibs["+ii+"].shulv'/>"+product.shulv+"</td>"+
			   "<td width='75' field='dpzk'><input type='text' name='xsddzhibs["+ii+"].dpzk'/></td>"+
				"<td width='75' field='wsdj'><input type='text' name='xsddzhibs["+ii+"].wsdj'/></td>"+
				"<td width='75' field='hsdj'><input type='text' name='xsddzhibs["+ii+"].hsdj'/></td>"+
				"<td width='75' field='wsje'><input type='text' name='xsddzhibs["+ii+"].wsje'/></td>"+
				"<td width='75' field='hsje'><input type='text' name='xsddzhibs["+ii+"].hsje'/></td>"+
				"<td width='75' field='se'><input type='text' name='xsddzhibs["+ii+"].se'/></td>"+
				"<td width='100' field='zke'><input type='text' name='xsddzhibs["+ii+"].zke'/></td>"+
				"<td width='100' field='fhck'><input type='text' name='xsddzhibs["+ii+"].fhck'/></td>"+
				"<td width='100' field='shdw'><input type='text' name='xsddzhibs["+ii+"].shdw'/></td>"+
				"<td width='150' field='jhfhrq'><input type='text' name='xsddzhibs["+ii+"].jhfhrq'/></td>"+
				"<td width='150' field='yqshrq'><input type='text' name='xsddzhibs["+ii+"].yqshrq'/></td>"+
			"</tr>"
			
		
	$("#maintain-right").append(tr);
	});
	
}
$().ready(function(){
	$(".searRR").unbind("click");
	$(".searRR").bind("click",function(){
		addTD();
		$("#seek").show();
	});
	$(".btn").unbind("click");
	$(".btn").bind("click",function(){
		callBack_product();
		return false;
	
	});
	
});

</script>
</head>
<body>
<s:form action="xsddAction_saveXsdd.action">
<table id="wrap">
	<tr>
    	<td id="rig_top" >
            <div   style="overflow:auto; height:190px;">
            <table class="content" style="font-size:12px;">
                <tr>
                    <td class="one" style="width:66px;">订货日期</td>
                    <td class="inp"><s:textfield name="query_zhub.dhrq" id="dhrq"></s:textfield></td>
                    <td class="one">失效日期</td>
                    <td class="inp"><s:textfield name="query_zhub.sxrq" id="sxrq" cssClass="current"></s:textfield></td>
                </tr>
                <tr>
                    <td style="color:#00F">客户名称</td>
                    <td class="inp"><s:textfield name="query_zhub.khmc"></s:textfield></td>
                    <td style="color:#00F">整单扣率</td>
                    <td class="inp"><s:textfield name="query_zhub.zdkl"/></td>
                </tr>
                <tr>
                    <td class="one" style="color:#00F">销售部门</td>
                    <td class="inp"><input type="text" name="query_zhub.xsbm" style="background:url(images/search.png) no-repeat 226px center #F6F9FD;" onclick="data()"/></td>
                    <td class="one" style="color:#00F">业务员</td>
                    <td class="inp"><input type="text" name="query_zhub.ywy" style="background:url(images/search.png) no-repeat 226px center #F6F9FD;" onclick="data()"/></td>
                </tr>
                <tr>
                    <td style="color:#00F">开票单位</td>
                    <td class="inp"><input type="text" name="query_zhub.kpdw" style="text-align:right"/></td>
                    <td style="color:#00F">收货地区</td>
                    <td class="inp"><input type="text" name="query_zhub.shdq" style="text-align:right"/></td>
                    <td style="color:#00F">收货地址</td>
                    <td class="inp"><input type="text" name="query_zhub.shdz" style="text-align:right"/></td>
                </tr>
                <tr>
					<td class="one" style="color:#00F">审批人</td>
                    <td class="inp"><input type="text"  style="background:url(images/search.png) no-repeat 226px center #F6F9FD;" onclick="data()"/></td>
					<td class="one" style="width:66px;">审批日期</td>
                    <td class="inp"><input type="text" id='dhrq'/></td>
                </tr>
				<tr>
					<td class="one" style="color:#00F">制单人</td>
                    <td class="inp"><input type="text"  style="background:url(images/search.png) no-repeat 226px center #F6F9FD;" onclick="data()"/></td>
					<td class="one" style="width:66px;">制单日期</td>
                    <td class="inp"><input type="text"/></td>
					<td class="one" style="color:#00F">修改人</td>
                    <td class="inp"><input type="text"  style="background:url(images/search.png) no-repeat 226px center #F6F9FD;" onclick="data()"/></td>
				</tr>
				<tr>
					<td class="one" style="width:66px;">修改日期</td>
                    <td class="inp"><input type="text"/></td>
				</tr>
				<tr>
					<td class="one" style="width:66px;">整单税价合计</td>
                    <td class="inp"><input type="text" name="query_zhub.zdsjhj"/></td>
                    <td class="one" style="width:66px;">收现款金额</td>
                    <td class="inp"><input type="text" name="query_zhub.sxkje"/></td>
                    <td class="one" style="width:66px;">是否退货</td>
                    <td class="inp"><input type="radio" name="query_zhub.thbz"/></td>
				</tr>
            </table>
           </div>
		</td>
    </tr>
    <tr>
    	<td id="right_center" >
            <div  style="height:213px; width:1150px; overflow:auto;">
            <table cellspacing="0" cellpadding="0"  id="maintain-right"  style="font-size:12px;" width="2000">
                <tr class="two" align="center">
                    <td width="30" field="hh">
                    	<div class="inp_search">
                    		<span class="searRR"></span>
                    	</div>
                    		行号</td>
                    <td width="75" field="spmc">商品名称</td>
                    <td width="75" field="spbm">商品编码</td>
                    <td width="75" field="xh">型号</td>
                    <td width="50" field="dw">单位</td>
                    <td width="100" field="sl">数llllllll量</td>
                    <td width="30" field="shulv">税率</td>
                    <td width="30" field="dpzk">单品扣率</td>
						<td width="75" field="wsdj">无税单价</td>
						<td width="75" field="hsdj">含税单价</td>
						<td width="75" field="wsje">无税金额</td>
						<td width="75" field="hsje">含税金额</td>
						<td width="75" field="se">税额</td>
						<td width="100" field="zke">折扣额</td>
						<td width="100" field="fhck">发货仓库</td>
						<td width="100" field="shdw">收货单位</td>
						<td width="150" field="jhfhrq">计划发货日期</td>
						<td width="150" field="yqshrq">要求收货日期</td>
                </tr>
                <input type="hidden" id="zhib" value="xsddzhibs"/>
               <!--  <tr align="center"> -->
                   <!--  <td style="width:30px; text-align:center; background:#E2E2E2;">
                    	<div class="inp_search">
                    		<span class="searRR"></span>
                    	</div>
                    </td> -->
                    <td class="inp" item="spmc">
                    	
                    	<div id="seek">
                    	 	<div class="seek_con_top">
	                        	<h5>商品信息</h5>
	                            <span class="seek_close" onclick="allclose()"></span>
	                        </div>
	                        <div class="seek_con">
	                        	<div style="overflow:scroll; overflow-x:hidden; height:275px;border:1px solid #898989;width:800px">
	                        		<table cellpadding="0" cellspacing="0" id="product_table">
	                        			<tr class="one">
	                        				<td width="500" item="radio">选择</td>
	                        			 	<td width="500" item="spmc">商品名称</td>
						                     <td width="300" item="xh">商品型号</td>
						                     <td width="300" item="spbm">商品编码</td>
													<td width="300" item="dw">商品单位</td>
													<td width="300" item="shulv">税率</td>
												</tr>
												<%-- <s:iterator value="#products" var="product" status="state">
													<tr class="one">
		                        				<td width="500" item="radio">选择</td>
		                        			 	<td width="500" item="spmc" >${product.spmc}</td>
							                     <td width="300" item="xh">${product.xh}</td>
							                     <td width="300" item="spbm">${product.spbm}</td>
														<td width="300" item="dw">${product.dw}</td>
														<td width="300" item="shulv">${product.shulv}</td>
													</tr>
												</s:iterator> --%>
												
	                        		</table>
	                        	</div>
	                        	<div class="btns">
                                	<button class="btn">确定</button>
                            	</div>
	                        </div>
                    	 </div>
                    </td>
                    <!-- <td style="border-collapse:collapse;  empty-cells:show;" item="spbm"><input type="text" style="width:100%;" name="xsddzhibs[0].spbm"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="xh"><input type="text" style="width:100%;" name="xsddzhibs[0].xh"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="dw"><input type="text" style="width:100%;" name="xsddzhibs[0].dw"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="sl"><input type="text" style="width:100%;" name="xsddzhibs[0].sl"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="shulv"><input type="text" style="width:100%;" name="xsddzhibs[0].shulv"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="dpkl"><input type="text" style="width:100%;" name="xsddzhibs[0].dpkl"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="wsdj"><input type="text" style="width:100%;"  name="xsddzhibs[0].wsdj"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="hsdj"><input type="text" style="width:100%;" readonly="true" name="xsddzhibs[0].hsdj"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="wsje"><input type="text" style="width:100%;"  name="xsddzhibs[0].wsje"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="hsje"><input type="text" style="width:100%;" readonly="true" name="xsddzhibs[0].hsje"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="se"><input type="text" style="width:100%;" readonly="true" name="xsddzhibs[0].se"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="zke"><input type="text" style="width:100%;" readonly="true" name="xsddzhibs[0].zke"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="fhck"><input type="text" style="width:100%;"  name="xsddzhibs[0].fhck"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="shdw"><input type="text" style="width:100%;"  name="xsddzhibs[0].shdw"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="jhfhrq"><input type="text" style="width:100%;"  name="xsddzhibs[0].jhfhrq"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="yqshrq"><input type="text" style="width:100%;"  name="xsddzhibs[0].yqshrq"/></td>
                 -->
               <!--   </tr> -->
            </table>
           </div>
    	</td>
    </tr>
    <tr>
    	<td id="right-bot">
            <table style="font-size:12px;">
                <tr>
                    <td class="bot_1" style="color:#00F">制单人</td>
                    <td class="inp_1"><s:textfield name="query_zhub.zdr" cssClass="current"></s:textfield></td>
                    <td class="bot_1" style="color:#00F">修订人</td>
                    <td class="inp_1"><s:textfield name="query_zhub.xgr" cssClass="current"></s:textfield></td>
                    <td class="bot_1">审批人</td>
                    <td class="inp_1"><s:textfield name="query_zhub.spr" cssClass="current"></s:textfield></td>
                    <td  width="77px">审批日期</td>
                    <td class="inp_1"><s:textfield name="query_zhub.spsj"></s:textfield></td>
                </tr>
                <tr>
                    <td>制单时间</td>
                    <td class="inp_2"><s:textfield name="query_zhub.zdsj"></s:textfield></td>
                    <td>修订时间</td>
                    <td class="inp_2"><s:textfield name="query_zhub.xgsj"></s:textfield></td>
                    <td>审批时间</td>
                    <td class="inp_2"><s:textfield name="query_zhub.spsj"></s:textfield></td>
                </tr>
            </table>
        </td>
    </tr>
     <tr class="save">
       <td height="30" align="right" style="padding-right"><input type="submit" value="保存" class="search"/></td>
     </tr>
</table>
</s:form>
<ul id="menu" style="position:absolute;display:none;">
  
 </ul>
</body>
</html>
