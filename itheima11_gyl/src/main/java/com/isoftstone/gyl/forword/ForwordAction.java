package com.isoftstone.gyl.forword;

import com.opensymphony.xwork2.ActionSupport;

public class ForwordAction extends ActionSupport{

	private String method;
	
	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	@Override
	public String execute(){
		return this.method;
	}
	
}
