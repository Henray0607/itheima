package com.isoftstone.gyl.basedata.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.isoftstone.gyl.base.action.BaseAction;
import com.isoftstone.gyl.basedata.service.DepartmentService;
import com.isoftstone.gyl.domain.basedata.Department;
import com.isoftstone.gyl.query.PageResult;
import com.isoftstone.gyl.query.basedata.DepartmentQuery;
import com.opensymphony.xwork2.ActionContext;

@Controller("departmentAction")
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Resource(name="departmentService")
	private DepartmentService departmentService;
	
	private DepartmentQuery baseQuery = new DepartmentQuery();
	
	
	public String showPageResult(){
			baseQuery.setCurrentPage(getCurrentPage());
			PageResult<Department> departments = departmentService.getPageResult(baseQuery);
			List<Department> lists = departments.getRows();
			ActionContext.getContext().put("departments", departments);
		for (Department department : lists) {
			System.out.println(department.getName());
		}
			return LISTACTION;
	}
	
	public String deleteDepartmentById(){
		String id = ServletActionContext.getRequest().getParameter("did");
		
		departmentService.deleteEntity(Long.parseLong(id));
		return "showList";
			
	}
	public String addUI(){
		return ADDUI;
	}
	public String addDepartment(){
		Department department = super.getModel();
		departmentService.saveEntity(department);
		return "addDepartment";
	}
	public String updateUI(){
		Long id = Long.parseLong(ServletActionContext.getRequest().getParameter("did"));
		Department department = this.departmentService.getEntityById(id);
		ActionContext.getContext().put("department",department);
		System.out.println(department.getName());
		return UPDATEUI;
	}
	public String updateDepartment(){
		Department department = super.getModel();
		this.departmentService.updateEntity(department);
		return "updateDepartment";
	}
	
}

