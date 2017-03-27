/**
 * 
 */
package com.zl.service.spring;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.core.userdetails.UserDetails;

import com.zl.spring.security.CustomUserDetailsService;

/**
 * @author zlennon
 *
 */
public class SpringSecurity {

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
		ApplicationContext ac  = new ClassPathXmlApplicationContext("app-springSecurity.xml");
		CustomUserDetailsService c=(CustomUserDetailsService)ac.getBean("customUserDetailsService");
		UserDetails userDetails=c.loadUserByUsername("admin");
	}

}
