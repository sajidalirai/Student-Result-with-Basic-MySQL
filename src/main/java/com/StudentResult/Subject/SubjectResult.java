package com.StudentResult.Subject;

public class SubjectResult {
	
	private int rollNo;
	private String subject;
	private String subTeacher;
	private int totalMarks;
	private int obtainedMarks;
	
	public SubjectResult() {
		
	}

	public SubjectResult(int rollNo, String subject, String subTeacher, int totalMarks, int obtainedMarks) {
		super();
		this.rollNo = rollNo;
		this.subject = subject;
		this.subTeacher = subTeacher;
		this.totalMarks = totalMarks;
		this.obtainedMarks = obtainedMarks;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSubTeacher() {
		return subTeacher;
	}

	public void setSubTeacher(String subTeacher) {
		this.subTeacher = subTeacher;
	}

	public int getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}

	public int getObtainedMarks() {
		return obtainedMarks;
	}

	public void setObtainedMarks(int obtainedMarks) {
		this.obtainedMarks = obtainedMarks;
	}
	
	
	
	
	

}
