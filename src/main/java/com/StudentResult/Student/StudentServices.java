package com.StudentResult.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

@Service
public class StudentServices {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public static class studentRowMapper implements RowMapper<Student>{

		
		@Override
		public Student mapRow(ResultSet resultSet, int arg1) throws SQLException {
			Student student = new Student();
			student.setRollNo(resultSet.getInt("rollNo"));
			student.setName(resultSet.getString("name"));
			student.setStatus(resultSet.getString("status"));
			return student;
		}
		
	}
	
	public Collection<Student> getAllStudentResult(){
		String sql = "SELECT * FROM students";
		List<Student> students = jdbcTemplate.query(sql, new studentRowMapper());
		return students;
		
	}
	
	
	public Student getStudent(int rollNo) {
		String sql = "SELECT * FROM students WHERE rollNo = ?";
		Student student = jdbcTemplate.queryForObject(sql, new studentRowMapper(), rollNo);
		return student;
	}
	
	public void insertStudent(Student student) {
		String sql = "INSERT INTO students (rollNo, name, status) VALUES (?, ?, ?)";
		int rollNo = student.getRollNo();
		String name = student.getName();
		String status = student.getStatus();
		
		jdbcTemplate.update(sql, new Object[] {rollNo, name, status});
	}
	
	public void updateStudent(Student student) {
		
		String sql = "UPDATE students SET rollNo = ? , name = ?, status = ? ";
		int rollNo = student.getRollNo();
		String name = student.getName();
		String status = student.getStatus();
		
		jdbcTemplate.update(sql, new Object[] {rollNo, name, status});
	}
	
	public void deleteStudent(int rollNo) {
		String sql = "DELETE FROM students WHERE rollNo = ? ";
		jdbcTemplate.update(sql, rollNo);
	}

}
