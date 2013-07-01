package com;

import java.util.HashMap;
import java.util.Map;

public class Student {

	Integer studentNo;
	String name;
	
	Map<Integer,String> map = new HashMap<Integer,String>();
	
	public void addStudent(Integer studentNo,String name){//添加学生（学号&姓名）
		map.put(studentNo, name);
	}
	
	public int getTotal(){//得到学生总数
		return map.size();
	}
	
	public String getStudentName(Integer studentNo){//根据学号得到学生姓名
		return map.get(studentNo);
	}

}
