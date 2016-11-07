package com.isoftstone.gyl.login.dao;

import com.isoftstone.gyl.domain.basedata.User;

public interface LoginDao {

	public User authentication(String username,String password);
	
	
}
