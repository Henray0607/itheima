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
		
		//声明删除的事件
		/* GylUtils.basedata.deleteObj.deleteFunction({
			id:'deleteSome',
			checkboxname:'ids',
			controlCheckBox:'controlCheckbox',
			url:'departmentAction_deleteDepartments.action'
		}); */
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
<s:form action="departmentAction_deleteDepartments.action">
<table id="userwrap">	
	<tr class="user">
        <td class="right">
        	<table cellspacing="0" cellpadding="0" id="maintain-top" align="center"  width="900" style=" overflow:auto; height:40px;">
                <tr class="one" height="20">
                	<td class="btn" align="left"><input type="button" value="删除" id="deleteSome"/></td>
                </tr>
                <tr class="one" height="20">
                	<td><input type="checkbox" id="controlCheckbox"/></td>
                    <td width="300">部门名称</td>
                    <td width="300">描述</td>
					<td width="300">操作</td>
                </tr>
               	<s:iterator value="#departments.rows" var="department">
	                <tr align="center">
	                   <td><input type="checkbox" name="ids" value="${department.did}"/></td>
	                   <td><s:property value="name"/></td>
	                   <td><s:property value="description"/></td>
						    <td class="btn" align="center">
						   	<input type="button" id="update" value="修改" onclick="updateDepartment('${did}')"/>
						   	<input type="button" id="delete" value="删除" onclick="deleteDepartment('${did}')"/>
						    </td>
	                </tr>
              	</s:iterator>
             </table>
            <p style="width:900px; height:20px;font-size:12px;">
	<span class="page" style="float:right">
		<input type="button" param="1" flag="firstPage" value="首页"/>&nbsp;
		<input type="button" flag="prePage" param="${departments.currentPage-1}" value="上一页" />&nbsp;
		<input type="button" flag="nextPage" param="${departments.currentPage+1}"  last="${departments.totalPages}" value="下一页"/>&nbsp;
		<input type="button" param="${departments.totalPages}" flag="lastPage" value="尾页"/>&nbsp;
		<span>转到第<input name="basedataQuery.currentPage" id="pageNo" type="text" value="${basedataQuery.currentPage}" size="4" style="height:16px; width:28px; border:1px solid #999999; background:#FFF; border-radius:0;" />页 
		</span>&nbsp;&nbsp;<input type="button" value="转" onclick="gotoPage()" style=" padding:0 10px;"/>
		</span>&nbsp;&nbsp;共有${departments.totalRows}条记录，当前第 ${departments.currentPage}/${departments.totalPages}页</p>
        </td>
    </tr>
</table>
</s:form>
<div>
    <a href="departmentAction_addUI.action">
    	<img src="${pageContext.request.contextPath}/images/createNew.png" />
    </a>
</div>
</body>
</html>