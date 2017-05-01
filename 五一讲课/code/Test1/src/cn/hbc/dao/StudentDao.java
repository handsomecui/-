package cn.hbc.dao;

import java.util.List;

import cn.hbc.entity.Student;

public interface StudentDao {
	void add(Student e);
	void delete(Student e);
	void update(Student e);
	List<Student>query();
	List<Student>query(int l , int r);
	int getCount();
}
