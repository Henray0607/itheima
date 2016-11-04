package com.isoftstone.gyl.privilege.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.isoftstone.gyl.base.dao.BaseDao;
import com.isoftstone.gyl.base.service.impl.BaseServiceImpl;
import com.isoftstone.gyl.domain.privilege.Menuitem;
import com.isoftstone.gyl.privilege.dao.MenuitemDao;
import com.isoftstone.gyl.privilege.service.MenuitemService;

@Service("menuitemService")
public class MenuitemServiceImpl extends BaseServiceImpl<Menuitem> implements MenuitemService{

	@Resource(name="menuitemDao")
	private MenuitemDao menuitemDao;
	

	public BaseDao<Menuitem> getBaseDao() {
		return this.menuitemDao;
	}
	

}
