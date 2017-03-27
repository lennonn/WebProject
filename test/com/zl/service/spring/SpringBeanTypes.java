/**
 * 
 */
package com.zl.service.spring;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zlennon
 *
 */
public class SpringBeanTypes {

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
		ApplicationContext ad  =new ClassPathXmlApplicationContext("classpath:app-dao.xml");
		Class c =ad.getType("userDao");
		assertNotNull(c);
		fail("c is null"); // TODO
	}

}
