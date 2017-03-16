/**
 * 
 */
package com.zl.persistence.hibernate.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.zl.dto.domain.User;

/**
 * @author zlennon
 *
 */
public class UserDao {
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void saveUser(User user){
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
	}
}
