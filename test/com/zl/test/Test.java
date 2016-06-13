package com.zl.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.context.annotation.DependsOn;

public class Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	//@org.junit.Test
	public final void test() {
		// >>右移 1111->0111
		/*
		 * << : 左移运算符，num << 1,相当于num乘以2 >> : 右移运算符，num >> 1,相当于num除以2 >>> :
		 * 无符号右移，忽略符号位，空位都以0补齐
		 */
		System.out.println(15 >> 1);
		System.out.println(-1 >>> 1);

	}

	//@org.junit.Test
	public final void person() {
		/*
		 * 参加某国际学术研讨会的60名学者中,亚裔学者31人,博士33人,非亚裔学者中无博士学位的4人.
		 * 根据上述陈述,参加此次国际研讨会的亚裔博士有几人? ①亚裔学者=亚裔博士+亚裔非博士 ②博士=亚裔博士+非亚裔博士 于是有：
		 * 亚裔学者+博士+非亚裔非博士=亚裔博士+亚裔非博士+亚裔博士+非亚裔博士+非亚裔非博士=68 ——A式
		 * 按照概念,学者不是亚裔就是非亚裔的,要么是博士要么不是.所以有： 学者=亚裔+非亚裔=亚裔博士+亚裔非博士+非亚裔博士+非亚裔非博士=60
		 * ——B式
		 *
		 * 用A式-B式=亚裔博士=8
		 */

		int person = 60;
		int scolar = 31;
		int doctor = 33;

		int nonDoctor = person - doctor;
		int nonScolar = person - scolar;
		// scolar =

	}

	//@org.junit.Test
	public void ifTest() {
		int x = 3;
		int y = 1;
		if (x == y)
			System.out.println("Not equal");
		else
			System.out.println("Equal");

	}

	@org.junit.Test
	public void testObj(){

		        Object o=new Object(){
		            public boolean equals(Object obj){
		                return true;
		            }
		        };
		        System.out.println(o.equals("Fred"));
		    }
}