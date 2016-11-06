package com.isoftstone.gyl.privilege.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.isoftstone.gyl.base.dao.BaseDao;
import com.isoftstone.gyl.base.service.impl.BaseServiceImpl;
import com.isoftstone.gyl.domain.privilege.Role;
import com.isoftstone.gyl.privilege.dao.RoleDao;
import com.isoftstone.gyl.privilege.service.RoleService;

@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService{

	@Resource(name="roleDao")
	private RoleDao<Role> roleDao;
	
	@Override
	public BaseDao getBaseDao() {
		// TODO Auto-generated method stub
		return this.roleDao;
	}

	@Override
	public void deleteParentNode(Long pid) {
		// TODO Auto-generated method stub
		this.roleDao.deleteParentNode(pid);
	}

}
