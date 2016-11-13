package com.isoftstone.gyl.base.service;

import java.io.Serializable;
import java.util.Collection;

import com.isoftstone.gyl.query.BaseQuery;
import com.isoftstone.gyl.query.PageResult;

public interface BaseService<T> {

	public PageResult<T> getPageResult(final BaseQuery baseQuery);
	public void saveEntity(T t);
	public void updateEntity(T t);
	public T getEntityById(Serializable id);
	public void deleteEntitiesByIds(Serializable[] ids);
	public void deleteEntity(Serializable id);
	public Collection<T> getEntities();
	public Collection<T> getEntitiesByids(Serializable[] ids);
}
