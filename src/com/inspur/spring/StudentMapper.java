package com.inspur.spring;

import java.util.List;

//使用mybatis动态代理，需要提供的接口，它的包+类名要与mapper文件的namespace一致
public interface StudentMapper {
	//接口的方法名要与mapper文件中元素的ID一致
	public void insertStu(Student stu);
	public void deleteById(Integer id);
	public void updateById(Student stu);
	public List searchStu(Student stu);

}
