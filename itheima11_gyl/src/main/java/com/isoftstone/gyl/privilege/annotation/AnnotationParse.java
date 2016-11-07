package com.isoftstone.gyl.privilege.annotation;

import java.lang.reflect.Method;

public class AnnotationParse {

	public static String parse(Class targetClass,String methodName) throws Exception{
		String accessMehods = "";
		Method method = targetClass.getMethod(methodName);
		if(method.isAnnotationPresent(PrivilegeInfo.class)){//目标方法存在该注解
			PrivilegeInfo privilegeInfo = method.getAnnotation(PrivilegeInfo.class);
			accessMehods = privilegeInfo.name();
			return accessMehods;
		}else{//不存在该注解
			return null;
		}
		
	}
}
