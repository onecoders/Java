package com;

import java.util.HashMap;
import java.util.Map;

public class Student {

	Integer studentNo;
	String name;
	
	Map<Integer,String> map = new HashMap<Integer,String>();
	
	public void addStudent(Integer studentNo,String name){//���ѧ����ѧ��&������
		map.put(studentNo, name);
	}
	
	public int getTotal(){//�õ�ѧ������
		return map.size();
	}
	
	public String getStudentName(Integer studentNo){//����ѧ�ŵõ�ѧ������
		return map.get(studentNo);
	}

}
