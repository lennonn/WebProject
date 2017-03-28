/**
 * 
 */
package com.zl.persistence.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.zl.dto.domain.CUser;
import com.zl.persistence.dao.UserDao;

/**
 * @author zlennon
 *
 */
public class UserDaoHibernateImpl implements UserDao {
	SessionFactory sessionFactory;
	Session session;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void saveUser(CUser user){
		 session = sessionFactory.getCurrentSession();
		session.save(user);
	}

	/* (non-Javadoc)
	 * @see com.zl.persistence.dao.UserDao#getDatabase(java.lang.String)
	 */
	@Override
	public CUser getUser(String username) {
		try{
			session =sessionFactory.openSession();
			List<CUser>cusers=session.createQuery("from CUser").list();
			if(cusers.size()>0){
				for(CUser u:cusers){
					if(u.getUsername().equals(username))
						return u;
				}
			}
			return null;
		}finally{
			if(session != null)
				session.close();	
		}	
	}
	
		
	
}
