package com.StudentResult.Student;

public class Student {
	
	private int rollNo;
	private String name;
	private String status;
	
	
	
	public Student() {
	
	}

	public Student(int rollNo, String name, String status) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.status = status;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	

}
