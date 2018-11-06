package com.studentprj.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.studentprj.model.Course;

@Repository
public class CourseRepository {

	@PersistenceContext
	EntityManager em;
	
	public List<Course> getAllCourses() {
		TypedQuery <Course> namedQuery = em.createNamedQuery("find_all_courses", Course.class);
		List<Course> courseList = namedQuery.getResultList();
		return courseList;
	}
	
	public Course findById(int cid) {
		return em.find(Course.class, cid);
	}
	
	public Course update(Course crs) {
		return em.merge(crs);
	}
}
