/**
 * 
 */
package com.zl.persistence.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.zl.dto.domain.Dept;
import com.zl.persistence.dao.DeptDao;
import com.zl.service.facade.DeptService;

/**
 * @author zlennon
 *
 */
public class DeptDaoHibernateImpl implements DeptDao {
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/* (non-Javadoc)
	 * @see com.zl.service.facade.DeptService#saveDept(com.zl.dto.domain.Dept)
	 */
	public void saveDept(Dept dept) {
		Session session = sessionFactory.getCurrentSession();
		session.save(dept);
		
	}

}
