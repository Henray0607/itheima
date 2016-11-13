package com.isoftstone.gyl;


import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.isoftstone.gyl.base.dao.BaseDao;
import com.isoftstone.gyl.basedata.dao.ProductDao;
import com.isoftstone.gyl.domain.basedata.Department;
import com.isoftstone.gyl.domain.basedata.Product;
import com.isoftstone.gyl.domain.privilege.Privilege;
import com.isoftstone.gyl.privilege.dao.PrivilegeDao;
import com.isoftstone.gyl.query.basedata.DepartmentQuery;

public class SpringTest {

	
	@Test
	public void testSessionFactory(){
		ApplicationContext context = new ClassPathXmlApplicationContext("com/isoftstone/gyl/spring/applicationContext.xml");
		SessionFactory sessionFactory= (SessionFactory)context.getBean("sessionFactory");
	}
	@Test
	public void testSpring(){

		ApplicationContext context = new ClassPathXmlApplicationContext("com/isoftstone/gyl/spring/applicationContext.xml");
		SessionFactory sessionFactory= (SessionFactory)context.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from Department where name=?");
		query.setString(0, "你");
		List<Department> departments = query.list();
		
		Department department = departments.get(0);
		System.out.println(department.getName());
		transaction.commit();
		session.close();
	}
	@Test
	public void testSpring2(){

		ApplicationContext context = new ClassPathXmlApplicationContext("com/isoftstone/gyl/spring/applicationContext.xml");
		SessionFactory sessionFactory= (SessionFactory)context.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Long count = (Long)session.createQuery("select count(*) from Department").uniqueResult();
		System.out.println(count);
		transaction.commit();
		session.close();
	}
	@Test
	public void testBaseDaoCount(){
		ApplicationContext context = new ClassPathXmlApplicationContext("com/isoftstone/gyl/spring/applicationContext.xml");
		BaseDao baseDao= (BaseDao)context.getBean("baseDao");
		DepartmentQuery departmentQuery = new DepartmentQuery();
		departmentQuery.setName("你");
		departmentQuery.setDescription("你");
		int count = baseDao.getCount(departmentQuery);
		System.out.println(count);
		
		
		
	}
	@Test
	public void testprivilege(){
		ApplicationContext context = new ClassPathXmlApplicationContext("com/isoftstone/gyl/spring/applicationContext.xml");
		PrivilegeDao privilegeDao= (PrivilegeDao)context.getBean("privilegeDao");
		Collection<Privilege> privileges = privilegeDao.getMenuItemTreeByUid(2L);
		for (Privilege privilege : privileges) {
			System.out.println(privilege.getId());
		}
	}
	@Test
	public void testProduct(){
		Integer[] ids = {2,3};
		ApplicationContext context = new ClassPathXmlApplicationContext("com/isoftstone/gyl/spring/applicationContext.xml");
		ProductDao productDao= (ProductDao)context.getBean("productDao");
		Collection<Product> products = productDao.getEntitiesByids(ids);
		for (Product product : products) {
			System.out.println(product.getPid());
		}
	}
	
}
