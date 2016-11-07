package com.isoftstone.gyl.login.service;

import com.isoftstone.gyl.domain.basedata.User;

public interface LoginService {

	public User authentication(String username,String password);

}
