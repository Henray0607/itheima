package com.isoftstone.gyl.privilege.service;

import com.isoftstone.gyl.base.service.BaseService;
import com.isoftstone.gyl.domain.privilege.Role;

public interface RoleService extends BaseService<Role> {

	public void deleteParentNode(final Long pid);
}
