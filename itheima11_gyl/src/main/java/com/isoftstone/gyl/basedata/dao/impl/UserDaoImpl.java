package com.isoftstone.gyl.basedata.dao.impl;

import org.springframework.stereotype.Repository;

import com.isoftstone.gyl.base.dao.impl.BaseDaoImpl;
import com.isoftstone.gyl.basedata.dao.UserDao;
import com.isoftstone.gyl.domain.basedata.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

}
