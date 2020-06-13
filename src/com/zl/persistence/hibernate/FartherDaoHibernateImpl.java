/**
 * 
 */
package com.zl.persistence.hibernate;

import com.zl.dto.domain.CUser;
import com.zl.dto.domain.Farther;
import com.zl.dto.domain.Son;
import com.zl.persistence.dao.FartherDao;
import com.zl.persistence.dao.SonDao;
import com.zl.persistence.dao.UserDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * @author zlennon
 *
 */
public class FartherDaoHibernateImpl implements FartherDao {
	SessionFactory sessionFactory;
	Session session;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void saveFarther(Farther farther) {
		session = sessionFactory.getCurrentSession();
		session.save(farther);
	}
}
