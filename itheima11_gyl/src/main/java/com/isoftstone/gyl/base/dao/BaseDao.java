package com.isoftstone.gyl.base.dao;

import java.io.Serializable;
import java.util.Collection;

import com.isoftstone.gyl.query.BaseQuery;
import com.isoftstone.gyl.query.PageResult;

public interface BaseDao<T> {

	/**
	 * 分页查询
	 * @param baseQuery
	 * @return
	 * */
	public PageResult<T> findPageResult(final BaseQuery baseQuery);
	/**
	 * 不分页查询
	 * */
	public Collection<T> getEntities(Serializable[] ids);
	/**
	 * 保存
	 * */
	public void saveEntry(T t);
	/**
	 * 修改
	 * */
	public void updateEntry(T t);
	/**
	 * 删除一条
	 * */
	public void deleteEntry(Serializable id);
	/**
	 * 删除多条
	 * */
	public void deleteEntries(Serializable[] ids);
	/**
	 * 查询一条
	 * */
	public T getEntryById(Serializable id);
	/**
	 * 查询总的记录数
	 * @return 
	 * */
	public int getCount(final BaseQuery baseQuery);
	/**
	 * 查询所有记录
	 * @return
	 * */
	public Collection<T> getEntities();
	 
}
