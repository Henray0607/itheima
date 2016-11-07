package com.isoftstone.gyl.login.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.isoftstone.gyl.domain.basedata.User;
import com.isoftstone.gyl.login.dao.LoginDao;
import com.isoftstone.gyl.login.service.LoginService;

@Service("loginService")
public class LoginServiceImpl implements LoginService{

	@Resource(name="loginDao")
	private LoginDao loginDao;
	
	@Override
	public User authentication(String username, String password) {
		// TODO Auto-generated method stub
		return this.loginDao.authentication(username, password);
	}

	
}
