package com.isoftstone.gyl;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.isoftstone.gyl.basedata.dao.DepartmentDao;
import com.isoftstone.gyl.basedata.service.DepartmentService;
import com.isoftstone.gyl.domain.basedata.Department;
import com.isoftstone.gyl.query.PageResult;
import com.isoftstone.gyl.query.basedata.DepartmentQuery;

public class DepartmentTest {

	@Test
	public void testGetCount(){
		ApplicationContext context = new ClassPathXmlApplicationContext("com/isoftstone/gyl/spring/applicationContext.xml");
		DepartmentDao departmentDao = (DepartmentDao)context.getBean("departmentDao");
		DepartmentQuery departmentQuery = new DepartmentQuery();
		int count = departmentDao.getCount(departmentQuery);
		System.out.println(count);
		
	}
	@Test
	public void testPageResult(){
		ApplicationContext context = new ClassPathXmlApplicationContext("com/isoftstone/gyl/spring/applicationContext.xml");
		DepartmentDao departmentDao = (DepartmentDao)context.getBean("departmentDao");
		DepartmentQuery departmentQuery = new DepartmentQuery();
		departmentQuery.setCurrentPage(2);
		PageResult<Department> pageResult = departmentDao.findPageResult(departmentQuery);
		for (Department department : pageResult.getRows()) {
			System.out.println(department.getDid());
		}
	}
	
	@Test
	public void testServiceTransaction(){
		ApplicationContext context = new ClassPathXmlApplicationContext("com/isoftstone/gyl/spring/applicationContext.xml");
		DepartmentService departmentdao = (DepartmentService)context.getBean("departmentService");
		Department department = new Department();
		department.setName("你们");
		department.setDescription("你们");
		departmentdao.saveEntity(department);
	}
	
}
