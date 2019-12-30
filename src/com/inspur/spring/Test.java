package com.inspur.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//初始化spring的IOC容器
		//加载spring的配置文件
		
		//ApplicationContext  context=new ClassPathXmlApplicationContext("applicationContext.xml");
		//ApplicationContext  context=new ClassPathXmlApplicationContext("applicationContext2.xml");
		//ApplicationContext  context=new ClassPathXmlApplicationContext("applicationContext3.xml");
		ApplicationContext  context=new ClassPathXmlApplicationContext("applicationContext4.xml");
		//从容器中取出javabean
		Person person=(Person)context.getBean("chinese");
		person.useAxe();
		
		//再次从容器中获取一个javabean
		Person person1=(Person)context.getBean("chinese");
		//单例模式，其实，它们是共享的同一个实例
		System.out.println("person1==person:"+(person==person1));
		
		Axe axe=(Axe)context.getBean("steelAxe");
		Axe axe1=(Axe)context.getBean("steelAxe");
		//原型模式，每次容器都创建一个新的实例
		System.out.println("axe1==axe:"+(axe==axe1));
		
		
	}

}
