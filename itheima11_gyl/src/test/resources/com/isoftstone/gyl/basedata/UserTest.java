package com.isoftstone.gyl.basedata;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.isoftstone.gyl.basedata.dao.DepartmentDao;
import com.isoftstone.gyl.basedata.dao.UserDao;
import com.isoftstone.gyl.basedata.service.UserService;
import com.isoftstone.gyl.domain.basedata.Department;
import com.isoftstone.gyl.domain.basedata.User;

public class UserTest {

	@Test
	public void testUserDao(){
		ApplicationContext context = new ClassPathXmlApplicationContext("com/isoftstone/gyl/spring/applicationContext.xml");
		//UserDao userDao = (UserDao)context.getBean("userDao");
		DepartmentDao departmentDao = (DepartmentDao)context.getBean("departmentDao");
		SessionFactory sessionFactory = (SessionFactory)context.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		User user = new User();
		user.setUsername("你");
		Department department =departmentDao.getEntryById(4L);
		user.setDepartment(department);
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}
	@Test
	public void testUserDaofind(){
		ApplicationContext context = new ClassPathXmlApplicationContext("com/isoftstone/gyl/spring/applicationContext.xml");
		//UserDao userDao = (UserDao)context.getBean("userDao");
		UserDao userDao = (UserDao)context.getBean("userDao");
		User user = userDao.getEntryById(2L);
		System.out.println(user.getDepartment().getName());
		
	}
	@Test
	public void testUserService(){
		ApplicationContext context = new ClassPathXmlApplicationContext("com/isoftstone/gyl/spring/applicationContext.xml");
		//UserDao userDao = (UserDao)context.getBean("userDao");
		UserService userService = (UserService)context.getBean("userService");
		User user = userService.getEntityById(2L);
		System.out.println(user.getDepartment().getName());
		
	}
}
