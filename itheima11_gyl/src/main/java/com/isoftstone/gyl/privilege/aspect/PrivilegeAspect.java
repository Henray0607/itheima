package com.isoftstone.gyl.privilege.aspect;

import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.isoftstone.gyl.domain.privilege.Privilege;
import com.opensymphony.xwork2.ActionContext;

@Aspect
@Component("privilegeAspect")
public class PrivilegeAspect {

	@Pointcut("execution(* com.isoftstone.gyl.*.action.*.*(..)")
	private void accessMethod(){
		
	}
	
	@Around("accessMethod()")
	public Object accessTargetMethod(ProceedingJoinPoint joinPoint) throws Throwable{
		//得到用户拥有的权限功能
		HttpSession session = ServletActionContext.getRequest().getSession();
		Collection<Privilege> functions = (Collection<Privilege>) session.getAttribute("functions");
		if(functions!=null){
			boolean flag=false;
			return null;
			
		}else{
			ActionContext.getContext().getValueStack().push("您没有权限访问");;
			return "privilege_error";
		}
		
		
		
	}
}
