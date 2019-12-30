package com.inspur.spring;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class TestMybatis01 {
	
	public static void main(String[] args) throws Exception{
		InputStream inputStream=Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session=sqlSessionFactory.openSession();
		
		try{
			
			Student stu=session.selectOne("com.inspur.spring.StudentMapper.selectById",new Integer(3));
			System.out.println(stu.getStuId()+","+stu.getStuName()+","+stu.getStuPhone()+","+stu.getStuBirthday());
			/*
			//实例化javabean
			Student stu=new Student();
			stu.setStuId(1);
			stu.setStuName("Tom");
			stu.setStuPhone("13566667777");
			stu.setStuBirthday(new Date());
			//调用insert方法，将bean插入到表中
			session.insert("com.inspur.spring.StudentMapper.insertStu",stu);
			session.commit();
			
			List list=session.selectList("com.inspur.spring.StudentMapper.selectAll");
			for(int i=0;i<list.size();i++){
				Student stu=(Student)list.get(i);
				System.out.println(stu.getStuId()+","+stu.getStuName()+","+stu.getStuPhone()+","+stu.getStuBirthday());
			}
			
			
			Student stu=session.selectOne("com.inspur.spring.StudentMapper.selectById",new Integer(1));
			System.out.println(stu.getStuId()+","+stu.getStuName()+","+stu.getStuPhone()+","+stu.getStuBirthday());
			
			Integer cnt=session.selectOne("com.inspur.spring.StudentMapper.getCount");
			System.out.println(cnt);
			
			
			Student stu=new Student();
			stu.setStuId(1);
			stu.setStuName("Mike");
			
			session.update("com.inspur.spring.StudentMapper.updateById",stu);
			session.commit();
			
			session.delete("com.inspur.spring.StudentMapper.deleteById",new Integer(1));
			session.commit();
			
			
			List list=session.selectList("com.inspur.spring.StudentMapper.selectMap");
			for(int i=0;i<list.size();i++){
				Map map=(Map)list.get(i);
				System.out.println(map.get("STU_ID")+","+map.get("STU_NAME")+","+map.get("STU_PHONE")+","+map.get("STU_BIRTHDAY"));
			}
			
			HashMap map=new HashMap();
			map.put("name", "Tom");
			map.put("orderby", "stu_id");
			
			Student stu=new Student();
			stu.setStuName("Mike");
			stu.setStuId(1);
			session.update("com.inspur.spring.StudentMapper.updateStuTrim",stu);
			session.commit();
			
			Student stu=new Student();
			stu.setStuName("Bob");
			stu.setStuId(1);
			session.update("com.inspur.spring.StudentMapper.updateStuSet",stu);
			session.commit();
			List idList=new ArrayList();
			idList.add("1");
			idList.add("2");
			idList.add("3");
			idList.add("4");
			Map map=new HashMap();
			map.put("ids", idList);
			List list=session.selectList("com.inspur.spring.StudentMapper.selectByCollection2",new String[]{"1","2"});
			for(int i=0;i<list.size();i++){
				stu=(Student)list.get(i);
				System.out.println(stu.getStuId()+","+stu.getStuName()+","+stu.getStuPhone()+","+stu.getStuBirthday());
			}
			
			//得到动态代理对象
			StudentMapper studentMapper=session.getMapper(StudentMapper.class);
			
			Student stu=new Student();
			stu.setStuName("Mike");
			stu.setStuId(1);
			stu.setStuPhone("13988887776");
			//stu.setStuBirthday(new Date());//对于特殊类型的列，如果插入NULL值，需要指定jdbcType
			//studentMapper.insertStu(stu);
			//studentMapper.deleteById(new Integer(4));
			//studentMapper.updateById(stu);
			//session.commit();
			List list=studentMapper.searchStu(new Student());
			for(int i=0;i<list.size();i++){
				stu=(Student)list.get(i);
				System.out.println(stu.getStuId()+","+stu.getStuName()+","+stu.getStuPhone()+","+stu.getStuBirthday());
			}
			*/
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		
	}

}
