package com.isoftstone.gyl.business.base.service;

import java.io.Serializable;

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
	
}
