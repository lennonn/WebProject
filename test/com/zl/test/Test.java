package com.zl.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public class Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	//@org.junit.Test
	public final void test() {
		// >>���� 1111->0111
		/*
		 * << : ���������num << 1,�൱��num����2 >> : ���������num >> 1,�൱��num����2 >>> :
		 * �޷�����ƣ����Է��λ����λ����0����
		 */
		System.out.println(15 >> 1);
		System.out.println(-1 >>> 1);

	}

	//@org.junit.Test
	public final void person() {
		/*
		 * �μ�ĳ���ѧ�����ֻ��60��ѧ����,����ѧ��31��,��ʿ33��,������ѧ�����޲�ʿѧλ��4��.
		 * �����������,�μӴ˴ι�����ֻ�����Ჩʿ�м���? ������ѧ��=���Ჩʿ+����ǲ�ʿ �ڲ�ʿ=���Ჩʿ+�����Ჩʿ �����У�
		 * ����ѧ��+��ʿ+������ǲ�ʿ=���Ჩʿ+����ǲ�ʿ+���Ჩʿ+�����Ჩʿ+������ǲ�ʿ=68 ����Aʽ
		 * ���ո���,ѧ�߲���������Ƿ������,Ҫô�ǲ�ʿҪô����.�����У� ѧ��=����+������=���Ჩʿ+����ǲ�ʿ+�����Ჩʿ+������ǲ�ʿ=60
		 * ����Bʽ
		 *
		 * ��Aʽ-Bʽ=���Ჩʿ=8
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
		            @Override
					public boolean equals(Object obj){
		                return true;
		            }
		        };
		        System.out.println(o.equals("Fred"));
		    }
}