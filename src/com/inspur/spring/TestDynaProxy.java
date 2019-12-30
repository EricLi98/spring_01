package com.inspur.spring;

public class TestDynaProxy {
	
	public static void main(String[] args) {
		IPerson person=(IPerson)DynaProxyFactory.getProxy(new PersonObj());
		person.sleep();
		person.eating();
	}
	

}
