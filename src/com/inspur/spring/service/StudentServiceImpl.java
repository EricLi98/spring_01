package com.inspur.spring.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.inspur.spring.bean.Student;
import com.inspur.spring.mapper.StudentMapper;

public class StudentServiceImpl implements StudentService {
	//通过注解实现注入
	@Autowired
	private StudentMapper studentMapper;
	public StudentMapper getStudentMapper() {
		return studentMapper;
	}

	public void setStudentMapper(StudentMapper studentMapper) {
		this.studentMapper = studentMapper;
	}

	@Override
	public void insertStu(Student stu) {
		// TODO Auto-generated method stub
		this.studentMapper.insertStu(stu);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		this.studentMapper.deleteById(id);
	}

}
