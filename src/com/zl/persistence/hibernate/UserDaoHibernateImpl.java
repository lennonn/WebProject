/**
 * 
 */
package com.zl.persistence.hibernate;

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

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void saveUser(CUser user){
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
	}

	/* (non-Javadoc)
	 * @see com.zl.persistence.dao.UserDao#getDatabase(java.lang.String)
	 */
	@Override
	public CUser getDatabase(String username) {
		// TODO Auto-generated method stub
		return new CUser();
	}
}
