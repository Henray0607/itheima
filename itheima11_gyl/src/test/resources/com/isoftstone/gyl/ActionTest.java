package com.isoftstone.gyl;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.isoftstone.gyl.basedata.action.DepartmentAction;
import com.isoftstone.gyl.query.basedata.DepartmentQuery;

public class ActionTest {

	@Test
	public void testGetCount(){
		ApplicationContext context = new ClassPathXmlApplicationContext("com/isoftstone/gyl/spring/applicationContext.xml");
		DepartmentAction departmentAction= (DepartmentAction)context.getBean("departmentAction");
		DepartmentQuery departmentQuery = new DepartmentQuery();
		departmentAction.showPageResult();
		
	}
}
