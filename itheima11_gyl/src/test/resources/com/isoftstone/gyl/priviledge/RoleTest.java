package com.isoftstone.gyl.priviledge;

import java.util.Collection;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.isoftstone.gyl.basedata.service.UserService;
import com.isoftstone.gyl.domain.basedata.User;
import com.isoftstone.gyl.domain.privilege.Privilege;
import com.isoftstone.gyl.domain.privilege.Role;
import com.isoftstone.gyl.privilege.dao.PrivilegeDao;
import com.isoftstone.gyl.privilege.dao.RoleDao;
import com.isoftstone.gyl.privilege.service.RoleService;

public class RoleTest {

	
	@Test
	public void testRole(){
		ApplicationContext context = new ClassPathXmlApplicationContext("com/isoftstone/gyl/spring/applicationContext.xml");
		SessionFactory sessionFactory = (SessionFactory)context.getBean("sessionFactory");
	}
	
	@Test
	public void testRoleSerivce(){
		ApplicationContext context = new ClassPathXmlApplicationContext("com/isoftstone/gyl/spring/applicationContext.xml");
		RoleService roleService = (RoleService)context.getBean("roleService");
		Role role = new Role();
		role.setIsParent(true);
		role.setName("CEO");
		role.setPid(0L);
		roleService.saveEntity(role);
	}
	
	@Test
	public void testdeleteRole(){
		ApplicationContext context = new ClassPathXmlApplicationContext("com/isoftstone/gyl/spring/applicationContext.xml");
		RoleDao roleDao = (RoleDao)context.getBean("roleDao");
		roleDao.deleteParentNode(30L);
	}
	@Test
	public void testFindPrivilegeS(){
		Integer[] ids = new Integer[]{1,2,5};
		ApplicationContext context = new ClassPathXmlApplicationContext("com/isoftstone/gyl/spring/applicationContext.xml");
		PrivilegeDao privilegeDao = (PrivilegeDao)context.getBean("privilegeDao");
		Collection<Privilege> privileges= privilegeDao.getPrivilegeByIds(ids);
		for (Privilege privilege : privileges) {
			System.out.println(privilege.getName());
		}
	}
	@Test
	public void testGetUserRole(){
		ApplicationContext context = new ClassPathXmlApplicationContext("com/isoftstone/gyl/spring/applicationContext.xml");
		UserService userService = (UserService)context.getBean("userService");
		User user = userService.getEntityById(1L);
		Collection<Role> roles = user.getRoles();
		for (Role role : roles) {
			System.out.println(role.getName());
		}
		
	}
}
