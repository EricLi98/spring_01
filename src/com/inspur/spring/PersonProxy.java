package com.inspur.spring;
import java.util.Date;

import org.apache.log4j.Logger;

//代理对象
public class PersonProxy implements IPerson {
	private IPerson person;//被代理的对象，进行业务处理
	private Logger logger = Logger.getLogger(PersonProxy.class);//获取Logger对象，进行日志记录

	public PersonProxy(IPerson ip){
		this.person=ip;
	}
	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		logger.info("开始执行时间:"+new Date());//根据日志的重要程序，调用不同的方法，从低到高：debug,info,warn,error
		person.sleep();
		logger.info("结束执行时间:"+new Date());
	}

	@Override
	public void eating() {
		// TODO Auto-generated method stub
		logger.info("开始执行时间:"+new Date());//根据日志的重要程序，调用不同的方法，从低到高：debug,info,warn,error
		person.eating();
		logger.info("结束执行时间:"+new Date());
	}

}
