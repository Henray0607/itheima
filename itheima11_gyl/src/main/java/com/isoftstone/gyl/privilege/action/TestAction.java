package com.isoftstone.gyl.privilege.action;

import com.isoftstone.gyl.base.action.BaseAction;
import com.isoftstone.gyl.domain.basedata.Product;
import com.isoftstone.gyl.query.basedata.ProductQuery;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class TestAction extends ActionSupport implements ModelDriven<Product>{
/*
	//方式一
	private String rid;
	
	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}*/
	//方式二
	private Product product = new Product();
	//方式三
	private ProductQuery productQuery;
	
	
	public ProductQuery getProductQuery() {
		return productQuery;
	}


	public void setProductQuery(ProductQuery productQuery) {
		this.productQuery = productQuery;
	}


	public String getParam(){
//		//方式一
//		System.out.println("rid in action:"+rid);
//		ActionContext.getContext().put("rid",rid );
		//方式二
		System.out.println(product);
		ActionContext.getContext().put("product",this.getModel());
		//方式三
		ActionContext.getContext().put("productQuery",productQuery);
		System.out.println(productQuery.getCurrentPage());
		return SUCCESS;
	}


	@Override
	public Product getModel() {
		// TODO Auto-generated method stub
		return this.product;
	}
}
