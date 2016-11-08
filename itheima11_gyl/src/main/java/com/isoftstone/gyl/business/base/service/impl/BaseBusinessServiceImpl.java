package com.isoftstone.gyl.business.base.service.impl;

import java.io.Serializable;
import java.util.Collection;

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

	@Override
	public T getEntitybyId_zhu(Serializable id) {
		return this.getBaseDao_zhu().getEntryById(id);
	}
	@Override
	public E getEntitybyId_zhi(Serializable id) {
		return this.getBaseDao_zhi().getEntryById(id);
	}
	@Override
	public Collection<T> getEntitiesbyIds_zhu(Serializable[] ids) {
		return this.getBaseDao_zhu().getEntities(ids);
	}
	@Override
	public Collection<E> getEntitiesbyId_zhi(Serializable[] ids) {
		// TODO Auto-generated method stub
		return this.getBaseDao_zhi().getEntities(ids);
	}
}
