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
public class SonDaoHibernateImpl implements SonDao {
	SessionFactory sessionFactory;
	Session session;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public void saveSon(Son son) {
		session = sessionFactory.getCurrentSession();
		session.save(son);
	}

	@Override
	public Son getSonById(String id) {
		session = sessionFactory.openSession();
		String sql = "from Son s left join fetch s.fartherByParentId where s.id='"+id+"'";
		List<Son> sons= session.createQuery(sql).list();

		session.close();
		return sons.get(0);
	}
}
