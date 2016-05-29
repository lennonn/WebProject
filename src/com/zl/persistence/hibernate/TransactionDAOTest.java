package com.zl.persistence.hibernate;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.zl.dto.domain.Dept;


public class TransactionDAOTest {
	SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//JdbcTemplate jdbcTemplate;
/*	//HibernateTemplate hibernateTemplate;
public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}*/
	//	public JdbcTemplate getJdbcTemplate() {
//		return jdbcTemplate;
//	}
//	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//		this.jdbcTemplate = jdbcTemplate;
//	}

	public void  saveDept(Dept dept){
		sessionFactory.getCurrentSession().save(dept);
	}

	public void deleteDept(Dept dept){
		sessionFactory.getCurrentSession().delete(dept);
	}

	public Dept queryDept(Dept dept){
		Session session = sessionFactory.getCurrentSession();
		//Dept dept2 = (Dept) session.load(Dept.class, dept.getDeptno());
		Dept dept3 = (Dept) session.get(Dept.class, dept.getDeptno());
		return dept3;
	}

	public List<Dept> queryDeptList(){
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Dept dept";
		Query query = session.createQuery(hql);
		List<Dept> list = query.list();
		return list;
	}
	public void  callProcedureTest(){
		Connection conn=null;
		CallableStatement proc = null;
		StringBuilder procStr = new StringBuilder("{ call ");
		procStr.append("GPFUNDAPPLY.AUTODEALSTATEBYCHECKNO").append("(?,?,?) }");
		try {
			//conn = hibernateTemplate.getSessionFactory().getCurrentSession();
			proc = conn.prepareCall(procStr.toString()); // 调用存储过程
			proc.registerOutParameter(2, Types.VARCHAR);
			proc.registerOutParameter(3, Types.VARCHAR);
			//proc.setDate(1,   new Date(8));
			proc.setString(1, "655");
			proc.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(proc != null){
				try{
					proc.close();
				}catch(Exception e){
					//logger.error("GfVouDtlDaoHibernateImpl.deleteVoudtl Close proc error:" + e);
				}
				proc = null;
			}
			if(conn != null){
				try{
					conn.close();
				}catch(Exception e){
					//logger.error("GfVouDtlDaoHibernateImpl.deleteVoudtl Close conn error:" + e);
				}
				conn = null;
			}
		}

	}
}
