package com.StudentResult.Subject;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubjectResultController {
	
	@Autowired
	private SubjectResultService subjectResService;
	
	@RequestMapping(value = "/students/{rollNo}/subjects")
	public Collection<SubjectResult> getStudentSubjects(@PathVariable int rollNo){
		return subjectResService.getStudentSebjects(rollNo);
	}
	
	@RequestMapping(value = "/students/{rollNo}/subjects/{subject}")
	public Collection<SubjectResult> getStudentResult(@PathVariable String subject, @PathVariable int rollNo) {
		return subjectResService.getStudentSubject(subject, rollNo);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/students/{rollNo}/subjects")
	public void insertSubjectResutl(@RequestBody SubjectResult	subjectResult, @PathVariable int rollNo) {
		subjectResService.insertSubjectResutl(subjectResult, rollNo);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/students/{rollNo}/subjects")
	public void updateSubjectResult(@RequestBody SubjectResult subRes, @PathVariable int rollNo) {
		subjectResService.updateSubjectResult(subRes, rollNo);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/students/{rollNo}/subjects/{subject}")
	public void deleteSubjectResult(@PathVariable int rollNo, @PathVariable String subject) {
		subjectResService.deleteSubjectResult(rollNo, subject);
	}

}
