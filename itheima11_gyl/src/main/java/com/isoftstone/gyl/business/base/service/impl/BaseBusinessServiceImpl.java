package com.isoftstone.gyl.business.base.service.impl;

import java.io.Serializable;

import com.isoftstone.gyl.base.dao.BaseDao;
import com.isoftstone.gyl.business.base.service.BaseBusinessService;
import com.isoftstone.gyl.query.BaseQuery;
import com.isoftstone.gyl.query.PageResult;

public abstract class BaseBusinessServiceImpl<T,E extends Serializable> implements BaseBusinessService<T,E> {

	public abstract BaseDao<T> getBaseDao_zhu();
	public abstract BaseDao<E> getBaseDao_zhi();
	
	@Override
	public PageResult<T> getEntities_zhu(BaseQuery baseQuery) {
		return this.getBaseDao_zhu().findPageResult(baseQuery);
	}

	@Override
	public PageResult<E> getEntities_zi(BaseQuery baseQuery) {

		return this.getBaseDao_zhi().findPageResult(baseQuery);
	}

}
