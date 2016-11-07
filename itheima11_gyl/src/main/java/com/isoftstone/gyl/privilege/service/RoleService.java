package com.isoftstone.gyl.privilege.service;

import java.io.Serializable;
import java.util.Collection;

import com.isoftstone.gyl.base.service.BaseService;
import com.isoftstone.gyl.domain.privilege.Role;

public interface RoleService extends BaseService<Role> {

	public void deleteParentNode(final Long pid);
	public Collection<Role> getRoleByIds(final Serializable[] ids);
}
