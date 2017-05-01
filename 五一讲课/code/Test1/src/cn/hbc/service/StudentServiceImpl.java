package cn.hbc.service;

import java.util.List;

import cn.hbc.dao.StudentDao;
import cn.hbc.dao.impl.StudentDaoImpl;
import cn.hbc.entity.Student;

public class StudentServiceImpl implements StudentService {

	StudentDao dao = new StudentDaoImpl();
	@Override
	public void add(Student e) {
		dao.add(e);
	}

	@Override
	public void delete(Student e) {
		dao.delete(e);
	}

	@Override
	public void update(Student e) {
		dao.update(e);
	}

	@Override
	public List<Student> query() {
		return dao.query();
	}

	@Override
	public List<Student> query(int l, int r) {
		return dao.query(l, r);
	}

	@Override
	public int getCount() {
		return dao.getCount();
	}

}
