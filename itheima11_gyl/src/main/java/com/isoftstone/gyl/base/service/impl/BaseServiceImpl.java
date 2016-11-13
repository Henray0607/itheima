package com.isoftstone.gyl.base.service.impl;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.transaction.annotation.Transactional;

import com.isoftstone.gyl.base.dao.BaseDao;
import com.isoftstone.gyl.base.service.BaseService;
import com.isoftstone.gyl.query.BaseQuery;
import com.isoftstone.gyl.query.PageResult;

public abstract class BaseServiceImpl<T> implements BaseService<T>{

	public abstract BaseDao getBaseDao();
		
	@Override
	public PageResult<T> getPageResult(BaseQuery baseQuery) {
		// TODO Auto-generated method stub
		return this.getBaseDao().findPageResult(baseQuery);
	}

	
	@Override
	public Collection<T> getEntitiesByids(Serializable[] ids) {
		// TODO Auto-generated method stub
		return this.getBaseDao().getEntities(ids);
	}
	@Transactional
	@Override
	public void saveEntity(T t) {

		this.getBaseDao().saveEntry(t);
	}

	@Transactional
	@Override
	public void updateEntity(T t) {
		this.getBaseDao().updateEntry(t);
		
	}

	@Override
	public T getEntityById(Serializable id) {
		return (T)this.getBaseDao().getEntryById(id);
	}

	@Transactional
	@Override
	public void deleteEntitiesByIds(Serializable[] ids) {
		this.getBaseDao().deleteEntries(ids);
	}

	@Transactional
	@Override
	public void deleteEntity(Serializable id) {
		this.getBaseDao().deleteEntry(id);
	}

	@Override
	public Collection<T> getEntities() {
		// TODO Auto-generated method stub
		return this.getBaseDao().getEntities();
	}

	
}
