package com.inspur.spring;

import java.util.Date;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LogAspectAnnotation {
	private Logger logger = Logger.getLogger(LogAspectAnnotation.class);
	
	@Pointcut("execution( * use*(..))")
	public void pointcutMethod(){}
	
	@Before("pointcutMethod()")
	public void log(JoinPoint  joinPoint){
		String name=(joinPoint.getSignature().getName());//方法名
		String typeName=(joinPoint.getSignature().getDeclaringTypeName());//所属类的名称
		logger.info(name+",execute,"+new Date());

	}
}
