package cn.hbc.test;

import org.junit.Test;

import cn.hbc.dao.StudentDao;
import cn.hbc.dao.impl.StudentDaoImpl;
import cn.hbc.entity.Student;

public class MyTest1 {
	@Test
	public void test1(){
		Student student = new Student("����", "Ů", 18);
		StudentDao dao = new StudentDaoImpl();
		for(int i = 1; i < 10; i++){
			student.setName("����" + i);
			student.setSex((i%2 == 1)?"��":"Ů");
			student.setAge(i + 18);
			dao.add(student);
		}
	}
}
