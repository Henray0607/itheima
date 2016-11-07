package com.isoftstone.gyl.privilege.dao;

import java.io.Serializable;
import java.util.Collection;

import com.isoftstone.gyl.base.dao.BaseDao;
import com.isoftstone.gyl.domain.privilege.Privilege;

public interface PrivilegeDao extends BaseDao<Privilege> {

	public Collection<Privilege> getPrivilegeByIds(final Serializable[] ids);
	public Collection<Privilege> getMenuItemTreeByUid(Long uid);
	public Collection<Privilege> getFunctionByUid(Long uid);
	
		
}
