package com.isoftstone.gyl.business.xsgl.action;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.isoftstone.gyl.base.action.BaseAction;
import com.isoftstone.gyl.business.xsgl.service.XsyddService;
import com.isoftstone.gyl.domain.business.xsgl.Xsyddzhib;
import com.isoftstone.gyl.domain.business.xsgl.Xsyddzhub;
import com.isoftstone.gyl.query.BaseQuery;
import com.isoftstone.gyl.query.PageResult;
import com.isoftstone.gyl.query.business.xsgl.XsyddzhibQuery;
import com.isoftstone.gyl.query.business.xsgl.XsyddzhubQuery;
import com.opensymphony.xwork2.ActionContext;

@Controller("xsyddAction")
@Scope("prototype")
public class XsyddAction extends BaseAction<XsyddzhubQuery>{

	@Resource(name="xsyddService")
	private XsyddService xsyddService;
	private XsyddzhubQuery xsyddzhubQuery = new XsyddzhubQuery();
	private XsyddzhibQuery xsyddzhibQuery = new XsyddzhibQuery();
	
	
	public XsyddzhibQuery getXsyddzhibQuery() {
		return xsyddzhibQuery;
	}


	public void setXsyddzhibQuery(XsyddzhibQuery xsyddzhibQuery) {
		this.xsyddzhibQuery = xsyddzhibQuery;
	}


	public String showXsydd(){
	
		System.out.println("zhubiaoQueryCurrentPage"+xsyddzhubQuery.getCurrentPage());
		System.out.println("zibiaoQueryCurrentPage"+xsyddzhibQuery.getCurrentPage());
		PageResult<Xsyddzhub> pageResult_zhu = this.xsyddService.getEntities_zhu(xsyddzhubQuery);
		PageResult<Xsyddzhib> pageResult_zhi = this.xsyddService.getEntities_zi(xsyddzhibQuery);
		//System.out.println(pageResult_zhu.getRows().get(0).getXsyddzhubid());
		ActionContext.getContext().put("pageResult_zhu", pageResult_zhu);
		ActionContext.getContext().put("pageResult_zhi", pageResult_zhi);
		
		return SUCCESS;
	}
	
	
	
}
