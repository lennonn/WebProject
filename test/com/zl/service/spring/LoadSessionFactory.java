/**
 * 
 */
package com.zl.service.spring;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zl.persistence.dao.UserDao;
import com.zl.spring.security.CustomUserDetailsService;

/**
 * @author zlennon
 *
 */
public class LoadSessionFactory {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public final void test() {
		ApplicationContext aContext = new ClassPathXmlApplicationContext("classpath:app*.xml");
		SessionFactory s =(SessionFactory)aContext.getBean("sessionFactory");
		UserDao userDao =(UserDao)aContext.getBean("userDao");
		CustomUserDetailsService c =(CustomUserDetailsService)aContext.getBean("customUserDetailsService");
		//UserService u =(UserService) aContext.getBean("userService");
		Session session =s.getCurrentSession();
		System.out.println(session);
	}

}
