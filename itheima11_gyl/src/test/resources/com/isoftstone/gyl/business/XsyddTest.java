package com.isoftstone.gyl.business;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.isoftstone.gyl.business.xsgl.service.XsyddService;
import com.isoftstone.gyl.domain.business.xsgl.Xsyddzhib;
import com.isoftstone.gyl.domain.business.xsgl.Xsyddzhub;
import com.isoftstone.gyl.query.PageResult;
import com.isoftstone.gyl.query.business.xsgl.XsyddzhibQuery;
import com.isoftstone.gyl.query.business.xsgl.XsyddzhubQuery;

public class XsyddTest {

	@Test
	public void testQueryXsydd(){
		ApplicationContext context = new ClassPathXmlApplicationContext("com/isoftstone/gyl/spring/applicationContext.xml");
		XsyddService xsyddservice= (XsyddService)context.getBean("xsyddService");
		Xsyddzhub xsyddzhub = xsyddservice.getEntitybyId_zhu(1L);
		XsyddzhibQuery xsyddzhibQuery = new XsyddzhibQuery();
		xsyddzhibQuery.setXsyddzhubid(xsyddzhub.getXsyddzhubid());
		PageResult<Xsyddzhib> xsyddzhibPageResult = xsyddservice.getEntities_zi(xsyddzhibQuery);
		
	  	System.out.println(xsyddzhibPageResult.getRows().size());
	}
	
	@Test
	public void testQueryByxsyddZhuQuery(){
		XsyddzhubQuery xsyddzhubQuery = new XsyddzhubQuery();
		xsyddzhubQuery.setKhmc("test");
		ApplicationContext context = new ClassPathXmlApplicationContext("com/isoftstone/gyl/spring/applicationContext.xml");
		XsyddService xsyddservice= (XsyddService)context.getBean("xsyddService");
		PageResult<Xsyddzhub> zhubs = xsyddservice.getEntities_zhu(xsyddzhubQuery);
		
		System.out.println(zhubs.getRows().size());

	}
	@Test
	public void testSaveTime() throws Exception{
		Xsyddzhub xsyddzhub= new Xsyddzhub();
		ApplicationContext context = new ClassPathXmlApplicationContext("com/isoftstone/gyl/spring/applicationContext.xml");
		XsyddService xsyddservice= (XsyddService)context.getBean("xsyddService");
		SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd ");
		String s= "2011-07-09 "; 
		Date date =  formatter.parse(s);
		xsyddzhub.setXgrq(date);
		xsyddservice.addXsydd(xsyddzhub);
		Long id = xsyddzhub.getXsyddzhubid();
		System.out.println(xsyddservice.getEntitybyId_zhu(id).getXgrq());
	}
}
