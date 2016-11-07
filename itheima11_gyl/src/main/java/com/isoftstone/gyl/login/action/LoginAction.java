package com.isoftstone.gyl.login.action;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.isoftstone.gyl.base.action.BaseAction;
import com.isoftstone.gyl.domain.basedata.User;
import com.isoftstone.gyl.domain.privilege.Privilege;
import com.isoftstone.gyl.login.service.LoginService;
import com.isoftstone.gyl.privilege.service.PrivilegeService;

@Controller("loginAction")
@Scope("prototype")
public class LoginAction extends BaseAction<User>{

	@Resource(name="loginService")
	private LoginService loginService;
	@Resource(name="privilegeService")
	private PrivilegeService privilegeService;
	
	public String authentication(){
		
		User user = this.loginService.
				authentication(this.getModel().getUsername(), this.getModel().getPassword());
		
		if(user==null){//用户名或密码错误
			this.addActionError("用户名或密码错误");
			
			return "login";
		}else{
			Collection<Privilege> functions = this.privilegeService.getFunctionByUid(user.getUid());
			this.getSession().setAttribute("user", user);
			//吧能够访问到的功能权限放到session中
			this.getSession().setAttribute("functions", functions);
			return "index";
		}
	}
	
	
	
}
