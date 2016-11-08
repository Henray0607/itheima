package com.isoftstone.gyl.business;

import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.isoftstone.gyl.basedata.action.DepartmentAction;
import com.isoftstone.gyl.business.xsgl.service.XsyddService;
import com.isoftstone.gyl.domain.business.xsgl.Xsyddzhib;
import com.isoftstone.gyl.domain.business.xsgl.Xsyddzhub;
import com.isoftstone.gyl.query.BaseQuery;
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
}
