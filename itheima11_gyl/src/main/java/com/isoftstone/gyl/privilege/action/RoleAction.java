package com.isoftstone.gyl.privilege.action;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.struts2.ServletActionContext;
import org.codehaus.jackson.map.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;

import com.isoftstone.gyl.base.action.BaseAction;
import com.isoftstone.gyl.domain.basedata.User;
import com.isoftstone.gyl.domain.privilege.Role;
import com.isoftstone.gyl.privilege.service.RoleService;
import com.opensymphony.xwork2.ActionContext;

@Controller("roleAction")
public class RoleAction extends BaseAction<Role>{
	
	@Resource(name="roleService")
	private RoleService roleService;
	
	public String showRoleTree(){
	
		
		Collection<Role> roles = this.roleService.getEntities();
		for (Role role : roles) {
			System.out.println(role.getName());
		}
		ActionContext.getContext().getValueStack().push(roles);
		return SUCCESS;
	}
	public String addRole(){
		
		Role role = new Role();
		BeanUtils.copyProperties(this.getModel(), role);
		this.roleService.saveEntity(role);
		ActionContext.getContext().getValueStack().push(role);
		return SUCCESS;
	}
	public String deleteRole(){
		System.out.println("removing ROLE");
		Long id = Long.parseLong(ServletActionContext.getRequest().getParameter("rid"));
		
		this.roleService.deleteEntity(id);
		return SUCCESS;
	}
	public String deleteParentNode(){
		Long id = Long.parseLong(ServletActionContext.getRequest().getParameter("rid"));

		this.roleService.deleteEntity(id);
		this.roleService.deleteParentNode(id);;
		return SUCCESS;
	}
	public String updateRole(){
		System.out.println("update ROLE");
		Long id = Long.parseLong(ServletActionContext.getRequest().getParameter("rid"));
		String name = ServletActionContext.getRequest().getParameter("name");
		Role role= this.roleService.getEntityById(id);
		role.setName(name);
		System.out.println(role.getPid());
		this.roleService.updateEntity(role);
		ActionContext.getContext().getValueStack().push(role);
		return SUCCESS;
	}
	
	public String getJson(){
		User user = new User();
		Map<String,Object> users = new HashMap<String, Object>();
		users.put("user", user);
		return SUCCESS;
	}
}
