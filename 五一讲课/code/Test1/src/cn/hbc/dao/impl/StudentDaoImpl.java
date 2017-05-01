package cn.hbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.hbc.dao.StudentDao;
import cn.hbc.entity.Student;
import cn.hbc.util.JdbcUtils;

public class StudentDaoImpl implements StudentDao {
	
	@Override
	public void add(Student e) {
		Connection conn = JdbcUtils.getConn();
		String sql = "insert into student(name,age,sex) values(?,?,?)";
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, e.getName());
			statement.setInt(2, e.getAge());
			statement.setString(3, e.getSex());
			statement.execute();
			statement.close();
			conn.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void delete(Student e) {
		Connection conn = JdbcUtils.getConn();
		String sql = "delete from student where id=1";
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.execute();
			statement.close();
			conn.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void update(Student e) {
		Connection conn = JdbcUtils.getConn();
		String sql = "update student set name=?,age=?,sex=? where id=?";
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, e.getName());
			statement.setInt(2, e.getAge());
			statement.setString(3, e.getSex());
			statement.setInt(4, 1);
			statement.execute();
			statement.close();
			conn.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public List<Student> query() {
		QueryRunner qr = new QueryRunner();
		Connection conn = JdbcUtils.getConn();
		List<Student> list;
		try {
			String sql = "select * from student";
			list = qr.query(conn, sql, new BeanListHandler<Student>(
					Student.class));
			conn.close();
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public List<Student> query(int l, int r) {
		QueryRunner qr = new QueryRunner();
		Connection conn = JdbcUtils.getConn();
		List<Student> list;
		try {
			String sql = "select * from student limit ?,?";
			list = qr.query(conn, sql, new BeanListHandler<Student>(
					Student.class), l, r);
			conn.close();
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public int getCount() {
		QueryRunner qr = new QueryRunner();
		Connection conn = JdbcUtils.getConn();
		try {
			String sql = "select count(*) from student";
			Long count = qr.query(conn, sql, new ScalarHandler<Long>());
			conn.close();
			return count.intValue();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
