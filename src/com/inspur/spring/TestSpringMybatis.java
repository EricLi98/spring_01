package com.inspur.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.inspur.spring.service.StudentService;

public class TestSpringMybatis {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext  context=new ClassPathXmlApplicationContext("applicationContext_mybatis.xml","service.xml");
		StudentService studentService=(StudentService)context.getBean("studentServiceImpl");
		com.inspur.spring.bean.Student stu=new com.inspur.spring.bean.Student();
		stu.setStuId(8);
		stu.setStuName("Mike");
		stu.setStuPhone("13988887777");
		studentService.insertStu(stu);
	}

}
