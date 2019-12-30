package com.inspur.spring;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Chinese implements Person {
	//定义axe成员，即Chinese依赖于axe
	private Axe axe;
	private List<String> list;
	private Map<String,Integer> map;
	private Set<String> set;
	public Set<String> getSet() {
		return set;
	}
	public void setSet(Set<String> set) {
		this.set = set;
	}
	public Map<String, Integer> getMap() {
		return map;
	}
	public void setMap(Map<String, Integer> map) {
		this.map = map;
	}
	
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public Axe getAxe() {
		return axe;
	}
	private String name;
	public void setAxe(Axe axe) {
		this.axe = axe;
	}
	//定义构造方法，完成成员变量的设置
	public Chinese(Axe axe){
		this.axe=axe;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	//定义一个空的构造方法
	public Chinese(){
	
	}
	@Override
	public void useAxe() {
		// TODO Auto-generated method stub
		System.out.println("Chinese use axe,"+name);
		if(list!=null){
			System.out.println(list.toString());
		}
		if(map!=null){
			System.out.println(map.toString());
		}
		if(set!=null){
			System.out.println(set.toString());
		}
		axe.chop();
	}

}
