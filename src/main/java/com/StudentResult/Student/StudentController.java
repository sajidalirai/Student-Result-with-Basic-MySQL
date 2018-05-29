package com.StudentResult.Student;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	@Autowired
	private StudentServices studentService;
	
	@RequestMapping(value = "/students")
	public Collection<Student> getAllStudentResult(){
		
		return studentService.getAllStudentResult();
		
	}
	
	@RequestMapping(value = "/students/{rollNo}")
	public Student getStudent(@PathVariable int rollNo) {
		return studentService.getStudent(rollNo);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/students")
	public void insertStudent(@RequestBody Student student) {
		studentService.insertStudent(student);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/students")
	public void updateStudent(@RequestBody Student student) {
		studentService.updateStudent(student);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/students/{rollNo}")
	public void deleteStudent(@PathVariable int rollNo) {
		studentService.deleteStudent(rollNo);
	}
	

}
