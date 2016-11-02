package com.isoftstone.gyl.basedata.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.isoftstone.gyl.base.action.BaseAction;
import com.isoftstone.gyl.basedata.service.DepartmentService;
import com.isoftstone.gyl.domain.basedata.Department;
import com.isoftstone.gyl.query.PageResult;
import com.isoftstone.gyl.query.basedata.DepartmentQuery;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

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
				
			PageResult<Department> departments = departmentService.getPageResult(baseQuery);
			List<Department> lists = departments.getRows();
		for (Department department : lists) {
			System.out.println(department.getName());
		}
			//			ActionContext.getContext().put("departments", departments);
			return	LISTACTION;
	}
	
}

















