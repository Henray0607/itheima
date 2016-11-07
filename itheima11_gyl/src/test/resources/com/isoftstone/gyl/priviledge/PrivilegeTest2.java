package com.isoftstone.gyl.priviledge;

import java.util.Collection;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.isoftstone.gyl.domain.privilege.Privilege;
import com.isoftstone.gyl.privilege.dao.PrivilegeDao;
import com.isoftstone.gyl.privilege.service.PrivilegeService;

public class PrivilegeTest2 {

	@Test
	public void getMenuItemByUserId(){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/isoftstone/gyl/spring/applicationContext.xml");
		PrivilegeService privilegeService = (PrivilegeService)context.getBean("privilegeService");
		Collection<Privilege> privileges = privilegeService.getMenuItemTreeByUid(1L);
		for (Privilege privilege : privileges) {
			System.out.println(privilege.getName());
		}
	}
}
