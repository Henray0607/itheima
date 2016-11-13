package com.isoftstone.gyl.privilege.action;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.isoftstone.gyl.base.action.BaseAction;
import com.isoftstone.gyl.domain.basedata.User;
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
		System.out.println("开始保存权限privilege。。。。");
		String strIds = ServletActionContext.getRequest().getParameter("ids");
		System.out.println(strIds);
		String[] ids = strIds.split("_");
		
		List<Privilege> privileges = (List<Privilege>) this.privilegeService.getPrivilegeByIds(ids);
		String riid = ServletActionContext.getRequest().getParameter("rid");
		System.out.println(this.rid);
		System.out.println(riid);
		Role role = this.roleService.getEntityById(Long.parseLong(riid));
		
		Set<Privilege> privilegesSet = new HashSet<Privilege>();
		privilegesSet.addAll(privileges);
		role.setPrivileges(privilegesSet);
		this.roleService.updateEntity(role);

		return SUCCESS;
	}
	
	public String privilegeEcho(){
		String rid = ServletActionContext.getRequest().getParameter("rid");
		Role role = this.roleService.getEntityById(Long.parseLong(rid));
		Set<Privilege> privilegesChecked = role.getPrivileges();
		
		Collection<Privilege> privilegesAll = this.privilegeService.getEntities();
		for (Privilege privilege : privilegesChecked) {
			for (Privilege p : privilegesAll) {
				if(privilege.getId()==p.getId()){
					p.setChecked(true);
				}
			}
		}
		ActionContext.getContext().getValueStack().push(privilegesAll);
		return SUCCESS;
	}
	public String showMenuitemTreeByUid(){
		User user = (User)this.getSession().getAttribute("user");
		Collection<Privilege> privileges = this.privilegeService.getMenuItemTreeByUid(user.getUid());
		Set<Privilege> privilegesSet = new HashSet<Privilege>(privileges);
		for (Privilege privilege : privileges) {
			System.out.println(privilege.getId());
		}
		ActionContext.getContext().getValueStack().push(new HashSet<Privilege>(privileges));
		return SUCCESS;
	}
}
