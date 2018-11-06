package com.studentprj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.studentprj.model.Course;
import com.studentprj.model.Student;
import com.studentprj.service.SMService;

@RestController
public class CMSRestController {

	@Autowired SMService service;
	
	@RequestMapping(value="/courses", method = RequestMethod.GET)
	public List<Course> listCourses() {
		return service.listCourses();
	}
	
	@RequestMapping(value="/students", method = RequestMethod.GET)
	public List<Student> listStudents() {
		return service.listStudents();
	}
	
	@RequestMapping(value="/enroll", method = RequestMethod.GET)
	public void saveEntry(@RequestParam String record) {
		service.saveEntry(record);
	}
}
