<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/gyl/common/common.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<script type="text/javascript">

</script>
</head>
<body>
<table id="userwrap">
	
	<tr class="user">
        <td class="right">
        	<table cellspacing="0" cellpadding="0" id="maintain-top" align="center"  width="900" style=" overflow:auto; height:40px;">
                <tr class="one" height="20">
                	<td class="btn" align="left"><input type="submit" value="删除"/></td>
                </tr>
                <tr class="one" height="20">
                	<td><input type="checkbox"/></td>
                    <td width="300">部门名称</td>
                    <td width="300">描述</td>
					<td width="300">操作</td>
                </tr>
                <s:iterator value="#departments.rows" >
                	<tr align="center">
	                	<td><input type="checkbox" name="dids" value="${did}"/></td>
	                    <td><s:property value="name"></s:property></td>
	                    <td><s:property value="description"/></td>
						<td class="btn" align="center">
							<input type="button" value="修改"/>
							<input type="button" value="修改"/>
						</td>
	                </tr>
                </s:iterator>
               	
        </td>
    </tr>
</table>
<div>
    <a href="departmentAction_addUI.action"><img src="${pageContext.request.contextPath}/images/createNew.png" /></a>
</div>
</body>
</html>