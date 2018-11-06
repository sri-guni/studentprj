package com.studentprj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentprj.common.SMSException;
import com.studentprj.model.Course;
import com.studentprj.model.Enrollments;
import com.studentprj.model.Student;
import com.studentprj.repository.CourseRepository;
import com.studentprj.repository.EnrollRepository;
import com.studentprj.repository.StudentRepository;

@Service
public class SMService {
	@Autowired CourseRepository crsRepo;
	@Autowired StudentRepository studRepo;
	@Autowired EnrollRepository enrRepo;

	public List<Course> listCourses() {
		return crsRepo.getAllCourses();
	}

	public List<Student> listStudents() {
		return studRepo.getAllStudents();
	}

	@Transactional(rollbackOn = SMSException.class)
	public void saveEntry(String record) {
		Student studInfo = getStudentData(record);
		Course courseInfo = getCourseData(record);

		Student checkStudExists = studRepo.findById(studInfo.getStudId());
		if(checkStudExists==null)
			studRepo.update(studInfo);

		Course checkCourseExists = crsRepo.findById(courseInfo.getCrsId());
		if(checkCourseExists==null)
			crsRepo.update(courseInfo);

		Enrollments enrollInfo = getEnrollmentData(record);
		enrRepo.update(enrollInfo);
	}

	private Student getStudentData(String record) {
		Student s = new Student();
		String[] fields = record.split(",");
		s.setStudId(Integer.parseInt(fields[0]));
		s.setName(fields[1]);
		s.setEmail(fields[2]);
		s.setPhone(fields[3]);
		return s;
	}

	private Course getCourseData(String record) {
		Course c = new Course();
		String[] fields = record.split(",");
		c.setCrsId(Integer.parseInt(fields[4]));
		c.setCrsName(fields[5]);
		c.setActFee(Float.parseFloat(fields[6]));
		return c;
	}

	private Enrollments getEnrollmentData(String record) {
		Enrollments e = new Enrollments();
		String[] fields = record.split(",");
		e.setStudId(Integer.parseInt(fields[0]));
		e.setCrsId(Integer.parseInt(fields[4]));
		e.setFeePaid(Float.parseFloat(fields[7]));
		e.setStartDate(fields[8]);
		return e;
	}
}
