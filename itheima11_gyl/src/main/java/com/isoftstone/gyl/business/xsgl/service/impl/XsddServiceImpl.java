package com.isoftstone.gyl.business.xsgl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isoftstone.gyl.base.dao.BaseDao;
import com.isoftstone.gyl.business.base.service.impl.BaseBusinessServiceImpl;
import com.isoftstone.gyl.business.xsgl.dao.XsddZhubDao;
import com.isoftstone.gyl.business.xsgl.dao.XsddZibDao;
import com.isoftstone.gyl.business.xsgl.service.XsddService;
import com.isoftstone.gyl.domain.business.xsgl.Xsddzhib;
import com.isoftstone.gyl.domain.business.xsgl.Xsddzhub;

@Service("xsddService")
public class XsddServiceImpl extends BaseBusinessServiceImpl<Xsddzhub, Xsddzhib> implements XsddService {

	
	@Resource(name="xsddZhubDao")
	private XsddZhubDao xsddZhubDao;
	@Resource(name="xsddZibDao")
	private XsddZibDao xsddZibDao;
	@Override
	public BaseDao<Xsddzhub> getBaseDao_zhu() {
		// TODO Auto-generated method stub
		return this.xsddZhubDao;
	}
	@Override
	public BaseDao<Xsddzhib> getBaseDao_zhi() {
		// TODO Auto-generated method stub
		return this.xsddZibDao;
	}
	
	@Transactional
	@Override
	public void addXsddZhub(Xsddzhub xsddzhub) {

		this.xsddZhubDao.saveEntry(xsddzhub);
	}
	
	


}
