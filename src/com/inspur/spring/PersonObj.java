package com.inspur.spring;

//被代理对象，处理实际的业务
public class PersonObj implements IPerson {

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println("睡觉中");

	}

	@Override
	public void eating() {
		// TODO Auto-generated method stub
		System.out.println("正在吃饭中");
	}

}
