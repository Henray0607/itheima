package com.isoftstone.gyl.business.xsgl.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.isoftstone.gyl.base.action.BaseAction;
import com.isoftstone.gyl.basedata.service.ProductService;
import com.isoftstone.gyl.business.xsgl.service.XsddService;
import com.isoftstone.gyl.domain.basedata.Product;
import com.isoftstone.gyl.domain.business.xsgl.Xsddzhib;
import com.isoftstone.gyl.domain.business.xsgl.Xsddzhub;
import com.isoftstone.gyl.query.business.xsgl.XsddzhubQuery;
import com.opensymphony.xwork2.ActionContext;

@Controller("xsddAction")
@Scope("prototype")
public class XsddAction extends BaseAction<XsddzhubQuery>{

	private XsddzhubQuery query_zhub=new XsddzhubQuery();
	
	
	private List<Xsddzhib> xsddzhibs = new ArrayList<Xsddzhib>();
	
	@Resource(name="xsddService")
	private XsddService xsddService;
	
	@Resource(name="productService")
	private ProductService productService;

	
	
	public XsddzhubQuery getQuery_zhub() {
		return query_zhub;
	}

	public void setQuery_zhub(XsddzhubQuery query_zhub) {
		this.query_zhub = query_zhub;
	}

	public List<Xsddzhib> getXsddzhibs() {
		return xsddzhibs;
	}

	public void setXsddzhibs(List<Xsddzhib> xsddzhibs) {
		this.xsddzhibs = xsddzhibs;
	}

	public String addUI(){
		return ADDUI;
	}
	
	public String saveXsdd(){
		Xsddzhub xsddzhub = new Xsddzhub();
		
		BeanUtils.copyProperties(this.query_zhub, xsddzhub);
		System.out.println(ServletActionContext.getRequest().getParameter("xsddzhibs[0].spmc"));
		
		System.out.println(this.xsddzhibs.get(0).getSpmc());
		xsddzhub.setXsddzhibs(new HashSet<Xsddzhib>(xsddzhibs));
		this.xsddService.addXsddZhub(xsddzhub);
		return "xsdd_save";
	}
}
