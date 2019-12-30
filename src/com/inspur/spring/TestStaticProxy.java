package com.inspur.spring;

public class TestStaticProxy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//使用时，直接使用代理对象，完成相应功能
		PersonProxy personProxy=new PersonProxy(new PersonObj());
		personProxy.eating();
		personProxy.sleep();

	}

}
