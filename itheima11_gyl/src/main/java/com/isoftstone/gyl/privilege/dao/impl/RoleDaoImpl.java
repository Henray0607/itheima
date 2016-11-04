package com.isoftstone.gyl.privilege.dao.impl;

import org.springframework.stereotype.Repository;

import com.isoftstone.gyl.base.dao.impl.BaseDaoImpl;
import com.isoftstone.gyl.domain.privilege.Role;
import com.isoftstone.gyl.privilege.dao.RoleDao;

@Repository("roleDao")
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao<Role>{
	

}
