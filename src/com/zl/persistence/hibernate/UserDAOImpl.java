package com.zl.persistence.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zl.dto.domain.User;
import com.zl.persistence.hibernate.dao.UserDAO;
@Repository
public class UserDAOImpl implements UserDAO {
	Session session;
	SessionFactory sessionFactory;
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void saveRegisterInfo(User u) {
		session = sessionFactory.getCurrentSession();
		session.save(u);
	}

}
