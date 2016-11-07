package com.isoftstone.gyl.privilege.service.impl;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.isoftstone.gyl.base.dao.BaseDao;
import com.isoftstone.gyl.base.service.impl.BaseServiceImpl;
import com.isoftstone.gyl.domain.privilege.Privilege;
import com.isoftstone.gyl.privilege.dao.PrivilegeDao;
import com.isoftstone.gyl.privilege.service.PrivilegeService;


@Service("privilegeService")
public class PrivilegeServiceImpl extends BaseServiceImpl<Privilege> implements PrivilegeService{

	@Resource(name="privilegeDao")
	private PrivilegeDao privilegeDao;
	@Override
	public BaseDao getBaseDao() {
		// TODO Auto-generated method stub
		return this.privilegeDao;
	}
	@Override
	public Collection<Privilege> getPrivilegeByIds(Serializable[] ids) {
		// TODO Auto-generated method stub
		return this.privilegeDao.getPrivilegeByIds(ids);
	}
	@Override
	public Collection<Privilege> getMenuItemTreeByUid(Long uid) {
		// TODO Auto-generated method stub
		return this.privilegeDao.getMenuItemTreeByUid(uid);
		
	}
	@Override
	public Collection<Privilege> getFunctionByUid(Long uid) {
		// TODO Auto-generated method stub
		return this.privilegeDao.getFunctionByUid(uid);
	}

}
