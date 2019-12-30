package com.inspur.spring;

import java.lang.reflect.Proxy;

//用于生成代理对象
public class DynaProxyFactory {
	
	//参数为被代理对象
	public static Object getProxy(Object target){
		//实例化Handler
		DynaProxyHandler handler = new DynaProxyHandler();
		handler.setTarget(target);
		
		return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(), handler);
	}

}
