package com.isoftstone.gyl.basedata.action;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.isoftstone.gyl.base.action.BaseAction;
import com.isoftstone.gyl.basedata.service.DepartmentService;
import com.isoftstone.gyl.basedata.service.UserService;
import com.isoftstone.gyl.domain.basedata.Department;
import com.isoftstone.gyl.domain.basedata.User;
import com.isoftstone.gyl.query.PageResult;
import com.isoftstone.gyl.query.basedata.UserQuery;
import com.opensymphony.xwork2.ActionContext;

@Controller("userAction")
@Scope("prototype")
public class UserAciton extends BaseAction<User>{

	@Resource(name="userService")
	private UserService userService;
	
	@Resource(name="departmentService")
	private DepartmentService departmentService; 
	private UserQuery userQuery = new UserQuery();
	
	public String showPageResult(){
		this.userQuery.setCurrentPage(super.getCurrentPage());
		PageResult<User> userList = this.userService.getPageResult(userQuery);
		ActionContext.getContext().put("users", userList);
		return LISTACTION;
	}
	public String addUser(){
		String did = ServletActionContext.getRequest().getParameter("did");
		Department department = this.departmentService.getEntityById(Long.parseLong(did));
		User user = this.getModel();
		user.setDepartment(department);
		this.userService.saveEntity(user);
		return "addUser_success";
	}
	public String addUI(){
		
		Collection<Department> departments = this.departmentService.getEntities();
		ActionContext.getContext().put("departments", departments);
		return ADDUI;
	}
	
	
	
	
	
}
