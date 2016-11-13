package com.isoftstone.gyl.business.xsgl.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.isoftstone.gyl.Utils.GylUtils;
import com.isoftstone.gyl.Utils.XsglFenLei;
import com.isoftstone.gyl.base.action.BaseAction;
import com.isoftstone.gyl.business.xsgl.service.XsyddService;
import com.isoftstone.gyl.domain.business.xsgl.Xsyddzhib;
import com.isoftstone.gyl.domain.business.xsgl.Xsyddzhub;
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
	
	private List<Xsyddzhib> xsyddzhibs = new ArrayList<Xsyddzhib>();
	
	
	
	public List<Xsyddzhib> getXsyddzhibs() {
		return xsyddzhibs;
	}


	public void setXsyddzhibs(List<Xsyddzhib> xsyddzhibs) {
		this.xsyddzhibs = xsyddzhibs;
	}


	public XsyddzhubQuery getXsyddzhubQuery() {
		return xsyddzhubQuery;
	}


	public void setXsyddzhubQuery(XsyddzhubQuery xsyddzhubQuery) {
		this.xsyddzhubQuery = xsyddzhubQuery;
	}


	public XsyddzhibQuery getXsyddzhibQuery() {
		return xsyddzhibQuery;
	}


	public void setXsyddzhibQuery(XsyddzhibQuery xsyddzhibQuery) {
		this.xsyddzhibQuery = xsyddzhibQuery;
	}


	public String showXsydd(){
		System.out.println("zhubiaoQueryCurrentPage"+xsyddzhubQuery.getCurrentPage());
		System.out.println("zibiaoQueryCurrentPage"+xsyddzhibQuery.getCurrentPage());
		System.out.println("khmc"+ServletActionContext.getRequest().getParameter("xsyddzhubQuery.khmc"));
		PageResult<Xsyddzhub> pageResult_zhu = this.xsyddService.getEntities_zhu(xsyddzhubQuery);
		System.out.println("客户名称"+xsyddzhubQuery.getKhmc());
		PageResult<Xsyddzhib> pageResult_zhi = this.xsyddService.getEntities_zi(xsyddzhibQuery);
		//System.out.println(pageResult_zhu.getRows().get(0).getXsyddzhubid());
		ActionContext.getContext().put("pageResult_zhu", pageResult_zhu);
		ActionContext.getContext().put("pageResult_zhi", pageResult_zhi);
		
		return SUCCESS;
	}
	public String addUI(){
		
		return ADDUI;
	}
	public String saveXsydd(){

		System.out.println(ServletActionContext.getRequest().getParameter("dhrqdhrq"));
		Xsyddzhub xsyddzhub = new Xsyddzhub();
		BeanUtils.copyProperties(this.xsyddzhubQuery,xsyddzhub);
		xsyddzhub.setXsyddzhibs(new HashSet<Xsyddzhib>(this.xsyddzhibs));
		xsyddzhub.setDdh(new GylUtils().getDdh(XsglFenLei.XSYDD));
		this.xsyddService.addXsydd(xsyddzhub);
		return "save_success";
	}
	
	
}
