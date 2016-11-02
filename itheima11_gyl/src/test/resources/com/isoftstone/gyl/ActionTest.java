package com.isoftstone.gyl;

import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.isoftstone.gyl.base.dao.BaseDao;
import com.isoftstone.gyl.basedata.action.DepartmentAction;
import com.isoftstone.gyl.basedata.dao.DepartmentDao;
import com.isoftstone.gyl.basedata.dao.impl.DepartmentDaoImpl;
import com.isoftstone.gyl.basedata.service.DepartmentService;
import com.isoftstone.gyl.domain.basedata.Department;
import com.isoftstone.gyl.query.BaseQuery;
import com.isoftstone.gyl.query.PageResult;
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
