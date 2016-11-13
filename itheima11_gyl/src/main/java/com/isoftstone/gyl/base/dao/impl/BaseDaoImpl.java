package com.isoftstone.gyl.base.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.isoftstone.gyl.base.dao.BaseDao;
import com.isoftstone.gyl.query.BaseQuery;
import com.isoftstone.gyl.query.PageResult;

public class BaseDaoImpl<T> implements BaseDao<T>{
	private Class classt;
	private ClassMetadata classMetadata;
	
	
	
	
	public BaseDaoImpl(){
		ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
		classt = (Class)type.getActualTypeArguments()[0];
	}
	@PostConstruct
	public void init(){
		this.classMetadata = this.hibernateTemplate.getSessionFactory().getClassMetadata(classt);
	}
	
	@Resource(name="hibernateTemplate")
	public HibernateTemplate hibernateTemplate;
	@Override
	public PageResult<T> findPageResult(final BaseQuery baseQuery) {
		int totalRows = this.getCount(baseQuery);
		
		final PageResult<T> pageResult = 
				new PageResult<T>(baseQuery.getCurrentPage(), baseQuery.getPageSize(), totalRows);
		final StringBuffer hql = new StringBuffer();
		hql.append("from "+classt.getSimpleName());
		hql.append(" where 1=1 ");
		final Map<String, Object> keyValues = baseQuery.buildWhere();
		for (Entry<String, Object> entry : keyValues.entrySet()) {
		/**
		 * 拼接查询语句
		 * */
			if(entry.getKey().contains(".")){
				hql.append("and "+entry.getKey()+"=:"+entry.getKey().split("\\.")[1]);
			}else{
				hql.append("and "+entry.getKey()+"=:"+entry.getKey());
			}
			 
		}
		return this.hibernateTemplate.execute(new HibernateCallback<PageResult<T>>() {

			@Override
			public PageResult<T> doInHibernate(Session session) throws HibernateException,
					SQLException {
				/**
				 * 给hql语句赋值
				 * */
				Query query = session.createQuery(hql.toString());
				for (Entry<String, Object> entry : keyValues.entrySet()) {
					if(entry.getKey().contains(".")){
						/**
						 * "where xsyddzhub.xsyddzhubid=:xsyddzhubid"的=:后面的赋值
						 */
						query.setParameter(entry.getKey().split("\\.")[1], entry.getValue());
					}else{
						query.setParameter(entry.getKey(), entry.getValue());
					}
				}

				int firstResult = (baseQuery.getCurrentPage()-1)*baseQuery.getPageSize();
				int maxResults = baseQuery.getPageSize();
				query.setFirstResult(firstResult).setMaxResults(maxResults);
				List<T> list = query.list();
				pageResult.setRows(list);
				return pageResult;
			}
		});
	}

	@Override
	public Collection<T> getEntities(Serializable[] ids) {
		StringBuffer stringBuffer =new StringBuffer();
		for (int i = 0; i < ids.length; i++) {
			if(i==ids.length-1)
				stringBuffer.append(ids[i]);
			else
				stringBuffer.append(ids[i]+",");
		}
		
		List<T> list = this.hibernateTemplate.find("from " +this.classt.getSimpleName()
				+" where "+this.classMetadata.getIdentifierPropertyName()
				+" in ("+stringBuffer.toString()+")");
		
		
		return list;
	}

	@Override
	public void saveEntry(T t) {
		this.hibernateTemplate.save(t);
	}

	@Override
	public void updateEntry(T t) {

		this.hibernateTemplate.update(t);
	}

	@Override
	public void deleteEntry(Serializable id) {
		T t = (T)this.hibernateTemplate.get(this.classt, id);
		this.hibernateTemplate.delete(t);
	}

	@Override
	public void deleteEntries(Serializable[] ids) {
		StringBuffer stringBuffer =new StringBuffer();
		for (int i = 0; i < ids.length; i++) {
			if(i==ids.length-1)
				stringBuffer.append(ids[i]);
			else
				stringBuffer.append(ids[i]+",");
		}
		
		List<T> list = this.hibernateTemplate.find("from " +this.classt.getSimpleName()
				+" where "+this.classMetadata.getIdentifierPropertyName()
				+" in ("+stringBuffer.toString()+")");
		this.hibernateTemplate.deleteAll(list);
		
	}

	@Override
	public T getEntryById(Serializable id) {
		return (T) this.hibernateTemplate.get(classt, id);
	}

	@Override
	public int getCount(final BaseQuery baseQuery) {
		return this.hibernateTemplate.execute(new HibernateCallback<Integer>() {

			@Override
			public Integer doInHibernate(Session session) throws HibernateException,
					SQLException {
				StringBuffer stringBuffer = new StringBuffer();
				stringBuffer.append("select count("+classMetadata.getIdentifierPropertyName()+") from "+classt.getSimpleName());
				stringBuffer.append(" where 1=1");
				Map<String,Object> keyValues = baseQuery.buildWhere();
				for (Entry<String,Object> entry : keyValues.entrySet()) {
					
					if(entry.getKey().contains(".")){
						stringBuffer.append("and "+entry.getKey()+"=:"+entry.getKey().split("\\.")[1]);
					}else{
						stringBuffer.append("and "+entry.getKey()+"=:"+entry.getKey());
					}
					
				}
				
				Query query = session.createQuery(stringBuffer.toString());
				for (Entry<String,Object> entry : keyValues.entrySet()) {
					if(entry.getKey().contains(".")){
						/**
						 * "where xsyddzhub.xsyddzhubid=:xsyddzhubid"的=:后面的赋值
						 */
						query.setParameter(entry.getKey().split("\\.")[1], entry.getValue());
					}else{
						query.setParameter(entry.getKey(), entry.getValue());
					}

				}
				
				Long count = (Long)query.uniqueResult();
				return count.intValue();
			}
			
			
		});
	}
	@Override
	public Collection<T> getEntities() {

		return this.hibernateTemplate.execute(new HibernateCallback<Collection<T>>() {

			@Override
			public Collection<T> doInHibernate(Session session) throws HibernateException,
					SQLException {
				
				Query query = session.createQuery("from "+classt.getSimpleName());
				Collection<T> ts = query.list();
				return ts;
			}
		});
	}
	@Override
	public Collection<T> getEntitiesByids(Serializable[] ids) {
		// TODO Auto-generated method stub
		StringBuffer hql = new StringBuffer();
		hql.append("from Product where pid in ('");
		for (int i=0;i<ids.length;i++) {
			if(i==ids.length-1){
				hql.append(ids[i]+"')");
				}else{
					hql.append(ids[i]+"','");
				}
		}
		
		return this.hibernateTemplate.find(hql.toString());
	}

}
