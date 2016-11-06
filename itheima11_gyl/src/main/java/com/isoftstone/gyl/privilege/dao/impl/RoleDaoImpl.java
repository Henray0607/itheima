package com.isoftstone.gyl.privilege.dao.impl;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.isoftstone.gyl.base.dao.impl.BaseDaoImpl;
import com.isoftstone.gyl.domain.privilege.Role;
import com.isoftstone.gyl.privilege.dao.RoleDao;

@Repository("roleDao")
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao<Role>{

	@Override
	public void deleteParentNode(final Long pid) {
		
		// TODO Auto-generated method stub
		this.hibernateTemplate.execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				// TODO Auto-generated method stub
				Query query =session.createQuery("delete from Role where pid=:pid");
				query.setParameter("pid", pid);
				query.executeUpdate();
				
				return null;
			}
		});
	}
	

}
