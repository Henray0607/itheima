package com.isoftstone.gyl.privilege.action;

import java.util.Collection;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.codehaus.jackson.map.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;

import com.isoftstone.gyl.base.action.BaseAction;
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
		System.out.println("saving ROLE");
		Role role = new Role();
		BeanUtils.copyProperties(this.getModel(), role);
		this.roleService.saveEntity(role);
		ActionContext.getContext().getValueStack().push(role);
		return SUCCESS;
	}
	
}
