package com.isoftstone.gyl.privilege.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport{

	private String rid;
	
	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getParam(){
		System.out.println(rid);
		ActionContext.getContext().put("rid",rid );
		return SUCCESS;
		
	}
}
