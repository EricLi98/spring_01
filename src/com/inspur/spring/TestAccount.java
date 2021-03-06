package com.inspur.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAccount {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext  context=new ClassPathXmlApplicationContext("applicationContext8.xml");
		IAccountDao dao=(IAccountDao)context.getBean("accountDao");
		
		String wang=dao.getAccountMoney("wang");
		String zhang=dao.getAccountMoney("zhang");
		System.out.println("wang:"+wang+",zhang:"+zhang);
		//dao.transAccount("wang", "zhang", 20);
		//dao.transAccountDeclare("wang", "zhang", 20);
		dao.transAccountDeclareAnnotation("wang", "zhang", 20);
	}

}
