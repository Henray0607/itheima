package com.isoftstone.gyl.basedata.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.isoftstone.gyl.base.dao.BaseDao;
import com.isoftstone.gyl.base.service.impl.BaseServiceImpl;
import com.isoftstone.gyl.basedata.dao.UserDao;
import com.isoftstone.gyl.basedata.service.UserService;
import com.isoftstone.gyl.domain.basedata.User;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{

	@Resource(name="userDao")
	private UserDao userDao;
	
	@Override
	public BaseDao getBaseDao() {
		
		return this.userDao;
	}

}
