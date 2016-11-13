package com.isoftstone.gyl.privilege.interceptor;

import java.util.Collection;

import org.apache.struts2.ServletActionContext;

import com.isoftstone.gyl.domain.privilege.Privilege;
import com.isoftstone.gyl.privilege.annotation.AnnotationParse;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class PrivilegeInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//1.得到用户拥有的功能权限
		Collection<Privilege> functions = (Collection<Privilege>) ServletActionContext.getRequest().getSession().getAttribute("functions");
		if(functions==null){
			ActionContext.getContext().getValueStack().push("您没有权限进行此操作");
			return "privilege_error";
		}
		//2.获取目标方法注解信息
		Class targetClass =  invocation.getAction().getClass();
		String methodName = invocation.getProxy().getMethod();
		
		
		String accessMethod = AnnotationParse.parse(targetClass, methodName);
		if("".equals(accessMethod)){
			//有注解但没有name属性
			return invocation.invoke();
		}else{
			
		//判断用户是否有该权限
		boolean flag = false;
			for (Privilege function : functions) {
				if(function.getName().equals(accessMethod)){
					flag=true;
					break;
				}
			}
			if(flag){
				return invocation.invoke();
			}else{
				ActionContext.getContext().put("errormsg","您没有权限访问");
				return "privilege_error";
			}
		}
	}

}
