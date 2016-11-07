package com.isoftstone.gyl.privilege.service;

import java.io.Serializable;
import java.util.Collection;

import com.isoftstone.gyl.base.service.BaseService;
import com.isoftstone.gyl.domain.privilege.Privilege;

public interface PrivilegeService extends BaseService<Privilege>{

	public Collection<Privilege> getPrivilegeByIds(Serializable[] ids);
	public Collection<Privilege> getMenuItemTreeByUid(Long uid);
	public Collection<Privilege> getFunctionByUid(Long uid);
}
