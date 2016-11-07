package com.isoftstone.gyl.privilege.action;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.struts2.ServletActionContext;
import org.codehaus.jackson.map.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import com.isoftstone.gyl.base.action.BaseAction;
import com.isoftstone.gyl.basedata.service.UserService;
import com.isoftstone.gyl.domain.basedata.User;
import com.isoftstone.gyl.domain.privilege.Role;
import com.isoftstone.gyl.privilege.service.RoleService;
import com.opensymphony.xwork2.ActionContext;

@Controller("roleAction")
public class RoleAction extends BaseAction<Role>{
	
	@Resource(name="roleService")
	private RoleService roleService;
	
	@Resource(name="userService")
	private UserService userService;
	
	private String uid;
	
	
	
	//转到设置角色页面

	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String showUserRolePage(){

		Collection<User> users = userService.getEntities();
		ActionContext.getContext().put("users", users);
		return "ok";
	}
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
	
	public String saveUserRole(){
		System.out.println(this.uid);
		User user = this.userService.getEntityById(Long.parseLong(this.uid));
		
		String ridsStr = ServletActionContext.getRequest().getParameter("rids");
		System.out.println(ridsStr);
		String[] rids = ridsStr.split("_"); 
		Collection<Role> roles = this.roleService.getRoleByIds(rids);
		Set<Role> rolesSet = new HashSet<Role>();
		rolesSet.addAll(roles);
		user.setRoles(rolesSet);
		this.userService.updateEntity(user);
		return SUCCESS;
	}
	
	public String userRoleEcho(){
		
		User user = this.userService.getEntityById(Long.parseLong(uid));
		System.out.println(user.getUsername());
		
		Set<Role> rolesUser = user.getRoles();
		
		Collection<Role> rolesList = this.roleService.getEntities();
		Set<Role> rolesAll = new HashSet<Role>();
		
		rolesAll.addAll(rolesList);
		for (Role  role: rolesUser) {
			for (Role r : rolesAll) {
					if(r.getRid()==role.getRid()){
						r.setChecked(true);
					}
					r.setPrivileges(null);
					r.setUsers(null);
			}
		}
		ActionContext.getContext().getValueStack().push(rolesAll);
		return SUCCESS;
	}
}
