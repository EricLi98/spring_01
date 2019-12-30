package com.inspur.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAopAnnotation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext  context=new ClassPathXmlApplicationContext("applicationContext6.xml");
		//从容器中取出javabean
		Person person=(Person)context.getBean("chinese");
		person.useAxe();
		

	}

}
