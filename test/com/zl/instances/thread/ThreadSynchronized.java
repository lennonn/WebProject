/**
 * 
 */
package com.zl.instances.thread;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author zlennon
 *
 */
public class ThreadSynchronized {

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
		Bank bank = new Bank();
		StaffA staffA = new StaffA(bank);
		staffA.setAmount(100);
		staffA.setOprType("increase");
		staffA.setSleepTime(300);
		//staffA.setOprType("reduce");
		StaffB staffB =new StaffB(bank);
		staffB.setAmount(200);
		staffB.setOprType("increase");
		//staffB.setOprType("reduce");
		Thread threadA = new Thread(staffA);
		threadA.setName("staffA");
		Thread threadB = new Thread(staffB);
		threadB.setName("staffB");
		threadA.start();
		threadB.start();
	}

}
