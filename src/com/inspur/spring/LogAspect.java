package com.inspur.spring;

import java.util.Date;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;

//切面类，进行增强处理(advice)
public class LogAspect {
	private Logger logger = Logger.getLogger(LogAspect.class);
	
	public void log(JoinPoint  joinPoint){
		String name=(joinPoint.getSignature().getName());//方法名
		String typeName=(joinPoint.getSignature().getDeclaringTypeName());//所属类的名称
		logger.info(name+",execute,"+new Date());

	}
}
