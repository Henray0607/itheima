package com.isoftstone.gyl.priviledge;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.isoftstone.gyl.domain.privilege.Role;
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
}
