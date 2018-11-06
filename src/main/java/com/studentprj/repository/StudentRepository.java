package com.studentprj.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.studentprj.model.Student;

@Repository
public class StudentRepository {
	@PersistenceContext
	EntityManager em;
	
	public List<Student> getAllStudents() {
		TypedQuery <Student> namedQuery = em.createNamedQuery("find_all_students", Student.class);
		List<Student> studentList = namedQuery.getResultList();
		return studentList;
	}
	
	public Student findById(int sid) {
		return em.find(Student.class, sid);
	}
	
	public Student update(Student stud) {
		return em.merge(stud);
	}
}
