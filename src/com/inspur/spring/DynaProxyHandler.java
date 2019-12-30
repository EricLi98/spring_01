package com.inspur.spring;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

import org.apache.log4j.Logger;

public class DynaProxyHandler implements InvocationHandler {
	
	private Logger logger = Logger.getLogger(DynaProxyHandler.class);
	private Object target;//被代理对象
	public Object getTarget() {
		return target;
	}
	public void setTarget(Object target) {
		this.target = target;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		logger.info("执行开始时间:" + new Date());
		Object result=method.invoke(target, args);//调用被代理对象的业务功能
		logger.info("执行结束时间:" + new Date());
		
		// TODO Auto-generated method stub
		return result;
	}

}
