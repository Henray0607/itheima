package com.isoftstone.dao.test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.isoftstone.dao.Person;

public class PersonTest {

	
	@Test
	public void testPerson(){
		Configuration configuration = new Configuration();
		configuration.configure();
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Person person = new Person();
		person.setName("li");
		person.setSex("nan");
		session.save(person);
		transaction.commit();
		session.close();
	}
}
