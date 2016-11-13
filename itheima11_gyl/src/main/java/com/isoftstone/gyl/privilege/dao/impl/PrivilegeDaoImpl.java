package com.isoftstone.gyl.privilege.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

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

	@Override
	public Collection<Privilege> getMenuItemTreeByUid(Long uid) {
		// TODO Auto-generated method stub
		if(uid.longValue()==1){//说明是管理员
			List<Privilege> privileges = this.hibernateTemplate.find("from Privilege");
			return privileges;
		}else{//普通员工
			//return this.hibernateTemplate.find("from Privilege p inner join fetch p.roles r inner join fetch r.users u where u.uid=? and p.type='1'",uid);
			return this.hibernateTemplate.find("from Privilege p inner join fetch p.roles r inner join fetch r.users u where u.uid=?",uid);
			
		}
	}

	@Override
	public Collection<Privilege> getFunctionByUid(Long uid) {
		if(uid.longValue()==1){//说明是管理员
			List<Privilege> privileges = this.hibernateTemplate.find("from Privilege where type='2'");
			
			return privileges;
			
		}else{//普通员工
			return this.hibernateTemplate.
				find("from Privilege p inner join fetch p.roles r inner join fetch r.users u where u.uid=? and p.type='2'",uid);
			
		}
	}
	
}
