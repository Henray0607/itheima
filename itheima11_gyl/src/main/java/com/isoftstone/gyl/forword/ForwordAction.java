package com.isoftstone.gyl.forword;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

public class ForwordAction extends ActionSupport{

	private String method;
	
	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String execute(){
		return this.method;
	}
	
}
