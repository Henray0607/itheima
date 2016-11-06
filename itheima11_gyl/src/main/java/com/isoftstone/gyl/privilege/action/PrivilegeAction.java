package com.isoftstone.gyl.privilege.action;

import java.util.Collection;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.isoftstone.gyl.base.action.BaseAction;
import com.isoftstone.gyl.domain.privilege.Privilege;
import com.isoftstone.gyl.domain.privilege.Role;
import com.isoftstone.gyl.privilege.service.PrivilegeService;
import com.isoftstone.gyl.privilege.service.RoleService;
import com.opensymphony.xwork2.ActionContext;

@Controller("privilegeAction")
public class PrivilegeAction extends BaseAction<Role>{


	@Resource(name="roleService")
	private RoleService roleService;
	@Resource(name="privilegeService")
	private PrivilegeService privilegeService;
	
	private String rid;
	
	
	public String getRid() {
		return rid;
	}


	public void setRid(String rid) {
		this.rid = rid;
	}


	public String showRoles(){
		
		Collection<Role> roles = this.roleService.getEntities();
		ActionContext.getContext().put("roles", roles);
		
		return "ok";
	}
	

	public String showPrivilegeTree(){
		System.out.println("begin privilege");
		Collection<Privilege> privileges = this.privilegeService.getEntities();
		ActionContext.getContext().getValueStack().push(privileges);
		return SUCCESS;
	}
	
	public String saveRolePrivilege(){
		String strIds = ServletActionContext.getRequest().getParameter("ids");
		String[] ids = strIds.split("_");
		
		Set<Privilege> privileges = (Set<Privilege>) this.privilegeService.getPrivilegeByIds(ids);
		
		Role role = this.roleService.getEntityById(rid);
		role.setPrivileges(privileges);
		this.roleService.updateEntity(role);
		return SUCCESS;
	}
}
