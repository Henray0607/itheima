package com.isoftstone.gyl.privilege.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.isoftstone.gyl.base.dao.impl.BaseDaoImpl;
import com.isoftstone.gyl.domain.privilege.Privilege;
import com.isoftstone.gyl.privilege.dao.PrivilegeDao;

@Repository("privilegeDao")
public class PrivilegeDaoImpl extends BaseDaoImpl<Privilege> implements PrivilegeDao{

	@Override
	public Collection<Privilege> getPrivilegeByIds(final Serializable[] ids) {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.execute(new HibernateCallback<Collection<Privilege>>() {

			@Override
			public Collection<Privilege> doInHibernate(Session session)
					throws HibernateException, SQLException {
				StringBuffer hql = new StringBuffer();
				hql.append("from Privilege where id in(");
				for (int i=0;i<ids.length;i++) {
					if(i==ids.length-1){
						
						hql.append(ids[i]);
					}else{
						hql.append(ids[i]+",");
					}
				}
				hql.append(")");
				Query query = session.createQuery(hql.toString());
				Collection<Privilege> privileges = query.list();
				return privileges;
			}
		});
	}
	
}
