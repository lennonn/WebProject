package com.zl.instances.extend;

public class Employee extends Person {
	/* ����Ĺ��췽�������ȵ��ø���Ĺ��췽�����������Ĺ��췽��û�����Ե�ָ��ʹ�ø�����ĸ����췽��������͵��ø��಻�������Ĺ��췽���� */
	String empID="000";

	public Employee(String id) {
		super(id);

		System.out.println(empID);
	}

	public static void main(String[] args) {
		Person person =new Employee("222");

	}
}
