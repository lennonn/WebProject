package com.zl.instances.extend;

public class Employee extends Person {
	/* 子类的构造方法总是先调用父类的构造方法，如果子类的构造方法没有明显地指明使用父类的哪个构造方法，子类就调用父类不带参数的构造方法。 */
	String empID="000";

	public Employee(String id) {
		super(id);

		System.out.println(empID);
	}

	public static void main(String[] args) {
		Person person =new Employee("222");

	}
}
