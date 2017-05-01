package cn.hbc.test;

import org.junit.Test;

import cn.hbc.dao.StudentDao;
import cn.hbc.dao.impl.StudentDaoImpl;
import cn.hbc.entity.Student;

public class MyTest1 {
	@Test
	public void test1(){
		Student student = new Student("张三", "女", 18);
		StudentDao dao = new StudentDaoImpl();
		for(int i = 1; i < 10; i++){
			student.setName("张三" + i);
			student.setSex((i%2 == 1)?"男":"女");
			student.setAge(i + 18);
			dao.add(student);
		}
	}
}
