<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/gyl/common/common.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<script type="text/javascript">
	$().ready(function(){
	    //设置分页要跳转到的url
		$("body").data("url","departmentAction_showPageResult.action");
	    var totalPages = ${departments.totalPages}
		$("body").data("totalPages",totalPages);
		//声明分页的事件
		GylUtils.basedata.initEvent();
		$.deleteObjForm();
		//声明修改的事件
		GylUtils.basedata.updateObj.updateFunction({
			url:'departmentAction_updateUI.action',
			id:'did'
		});
		
	});
	function deleteDepartment(did){
		window.location.href="deleteDepartmentById.action?did="+did;
	}
	function updateDepartment(did){
		window.location.href="departmentAction_updateUI.action?did="+did;
	}
	function gotoPage(){
		window.location.href="departmentAction_showPageResult.action?currentPage="+$("#pageNo").attr("value");
	}
	
	
</script>
</head>
<body>
<table id="userwrap">	
	<tr class="user">
        <td class="right">
        	<table cellspacing="0" cellpadding="0" id="maintain-top" align="center"  width="900" style=" overflow:auto; height:40px;">
                <tr class="one" height="20">
                	<td class="btn" align="left">
                			<a href="">删除选中
    							</a>
                		</td>
                </tr>
                <tr class="one" height="20">
                	  <td><input type="checkbox" id="controlCheckbox"/></td>
                    <td width="100">用户名</td>
                    <td width="100">密码</td>
                    <td width="100">号码</td>
                    <td width="200">邮箱</td>
						  <td width="100">部门</td>
						  <td width="200">操作</td>
                </tr>
               	<s:iterator value="#users.rows" var="user">
	                <tr align="center">
	                   <td><input type="checkbox" name="ids" value="${user.uid}"/></td>
	                   <td><s:property value="username"/></td>
	                   <td><s:property value="password"/></td>
	                   <td><s:property value="phone"/></td>
	                   <td><s:property value="email"/></td>
	                   <td><s:property value="%{#user.department.name}"/></td>
						    <td class="btn" align="center">
						   	<input type="button" id="update" value="修改" onclick=""/>
						   	<input type="button" id="delete" value="删除" onclick=""/>
						    </td>
	                </tr>
              	</s:iterator>
             </table>
            <p style="width:900px; height:20px;font-size:12px;">
	<span class="page" style="float:right">
		<input type="button" param="1" flag="firstPage" value="首页"/>&nbsp;
		<input type="button" flag="prePage" param="${users.currentPage-1}" value="上一页" />&nbsp;
		<input type="button" flag="nextPage" param="${users.currentPage+1}"  last="${users.totalPages}" value="下一页"/>&nbsp;
		<input type="button" param="${users.totalPages}" flag="lastPage" value="尾页"/>&nbsp;
		<span>转到第<input name="basedataQuery.currentPage" id="pageNo" type="text" value="${basedataQuery.currentPage}" size="4" style="height:16px; width:28px; border:1px solid #999999; background:#FFF; border-radius:0;" />页 
		</span>&nbsp;&nbsp;<input type="button" value="转" onclick="gotoPage()" style=" padding:0 10px;"/>
		</span>&nbsp;&nbsp;共有${users.totalRows}条记录，当前第 ${users.currentPage}/${users.totalPages}页</p>
        </td>
    </tr>
</table>
<div>
    <a href="departmentAction_addUI.action">
    	<img src="${pageContext.request.contextPath}/images/createNew.png" />
    </a>
</div>
</body>
</html>