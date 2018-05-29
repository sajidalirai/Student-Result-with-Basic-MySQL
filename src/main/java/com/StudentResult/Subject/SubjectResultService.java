package com.StudentResult.Subject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.StudentResult.Student.Student;

@Service
public class SubjectResultService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public static class SubjectResultRowMapper implements RowMapper<SubjectResult>{

		@Override
		public SubjectResult mapRow(ResultSet resultSet, int arg1) throws SQLException {
			
			SubjectResult subRes = new SubjectResult();
			subRes.setRollNo(resultSet.getInt("rollNo"));
			subRes.setSubject(resultSet.getString("subject"));
			subRes.setSubTeacher(resultSet.getString("subTeacher"));
			subRes.setTotalMarks(resultSet.getInt("totalMarks"));
			subRes.setObtainedMarks(resultSet.getInt("obtainedMarks"));
			return subRes;
		}
		
	}
	
	
	public Collection<SubjectResult> getStudentSebjects(int rollNo){
		
		String sql = "SELECT * FROM subjectresult WHERE rollNo = ?";
		
		Collection<SubjectResult> subResult = jdbcTemplate.query(sql, new SubjectResultRowMapper(), rollNo);
		
		return subResult;
	}
	
	public Collection<SubjectResult> getStudentSubject( String subject, int rollNo) {
		String sql = "SELECT * FROM subjectresult WHERE rollNo = "+rollNo+ " AND subject = ?";
		
		Collection<SubjectResult> subjectRes = jdbcTemplate.query(sql, new SubjectResultRowMapper(), subject);
		
		return subjectRes;
	}
	
	public void insertSubjectResutl(SubjectResult	subjectResult, int rollNo) {
		String sql = "INSERT INTO subjectresult (rollNo, subject, subTeacher, totalMarks, obtainedMarks) VALUES (?, ?, ?, ?, ? )";
		String subject = subjectResult.getSubject();
		String subTeacher = subjectResult.getSubTeacher();
		int totalMarks = subjectResult.getTotalMarks();
		int obtainedMarks = subjectResult.getObtainedMarks();
		
		jdbcTemplate.update(sql, new Object[] {rollNo, subject, subTeacher, totalMarks, obtainedMarks});
	}
	
	public void updateSubjectResult(SubjectResult subjectResult, int rollNo) {
		String subject1 = subjectResult.getSubject();
		String sql = "UPDATE subjectresult SET rollNo =?, subject =? , subTeacher = ? , totalMarks = ?, obtainedMarks = ? WHERE rollNo = "+ rollNo +" AND subject = \""+ subject1 +"\"";
		//String subject = subjectResult.getSubject();
		String subTeacher = subjectResult.getSubTeacher();
		int totalMarks = subjectResult.getTotalMarks();
		int obtainedMarks = subjectResult.getObtainedMarks();
		jdbcTemplate.update(sql, new Object[] {rollNo,  subject1, subTeacher, totalMarks, obtainedMarks});
	}
	
	public void deleteSubjectResult(int rollNo, String subject) {
		
		String sql = "DELETE FROM subjectresult WHERE rollNo = "+ rollNo +" AND subject = \""+ subject +"\"";
		jdbcTemplate.update(sql);
	}
	

}
