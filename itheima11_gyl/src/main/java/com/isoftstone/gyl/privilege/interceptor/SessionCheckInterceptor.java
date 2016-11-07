package com.isoftstone.gyl.privilege.interceptor;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.isoftstone.gyl.domain.basedata.User;
import com.isoftstone.gyl.domain.privilege.Privilege;
import com.isoftstone.gyl.privilege.annotation.AnnotationParse;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class SessionCheckInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {

		HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User)session.getAttribute("user");
		if(user!=null){
			return invocation.invoke();
		}else{
			return "index";
		}
		 
	}
}
