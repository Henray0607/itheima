<%@ page language="java" import="java.util.*,java.text.SimpleDateFormat" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/gyl/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
<script type="text/JavaScript" src="${pageContext.request.contextPath}js/jquery-1.4.2.js"></script>
<link href="css/style.css" rel="stylesheet" type="text/css"/>
<style type="text/css">
<!--
body {margin:0;}
.STYLE1 {
	font-size: 12px;
	color: #2b7dbb;
}
-->
</style>
<script type="text/JavaScript">
$().ready(function(){
	var date="";
	var myDate = new Date();
	var s=myDate.getMonth()+1
	date = date+myDate.getFullYear()+"/"+s+"/"+myDate.getDate();
	$("#date").text(date);
});


function logout(){
		var flag = confirm("确定注销吗？");
		if(flag){
			window.parent.location.href="login.jsp";
		}
}

</script>
</head>
<body>
<div id="topwrap">
	<div class="top">
		<div class="top_left"></div>
		<div class="top_right">
        	<span><a href="#">未读消息(0)</a><a href="#">代办事务(0)</a><a href="#">预警消息(0)</a><a href="#">快捷码</a></span>
            <input type="text" class="top_input"/><a href="#" class="arrow"></a>
        </div>
    </div>
    <div class="top_bottom">
    	<div class="top_bot_right">
        	<a id="logout" href="#" onclick="logout()" class="one">注销</a><a href="#" class="two">快速切换</a><a href="#" class="three">日志</a><a href="#" class="four">在线支持</a><a href="#" class="five">帮助<span></span></a>
        </div>
        <div class="top_bot_left">集团|<font style="color: black"><i><s:property value="#session.user.username"/></i></font>,您好！<span id="date"></span></div>
    </div>
</div>
</body>
</html>