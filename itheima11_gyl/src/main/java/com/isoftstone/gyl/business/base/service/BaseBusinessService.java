package com.isoftstone.gyl.business.base.service;

import java.io.Serializable;
import java.util.Collection;

import com.isoftstone.gyl.domain.business.xsgl.Xsyddzhub;
import com.isoftstone.gyl.query.BaseQuery;
import com.isoftstone.gyl.query.PageResult;

/**
 * 关于业务逻辑的抽象接口
 * T代表主表， E代表子表
 * */
public interface BaseBusinessService<T,E extends Serializable> {

	/**
	 * 返回主表的分页
	 * */
	public PageResult<T> getEntities_zhu(BaseQuery baseQuery);
	/**
	 * 
	 * 返回子表的分页
	 * */
	public PageResult<E> getEntities_zi(BaseQuery baseQuery);
	
	/**
	 * 通过id查询主表
	 * */
	public T getEntitybyId_zhu(Serializable id);
	public E getEntitybyId_zhi(Serializable id);
	
	public Collection<T> getEntitiesbyIds_zhu(Serializable[] ids);
	public Collection<E> getEntitiesbyId_zhi(Serializable[] ids);
	
}
