package com.studentprj.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.studentprj.model.Enrollments;

@Repository
public class EnrollRepository {
	@PersistenceContext
	EntityManager em;
	
	public Enrollments update(Enrollments enr) {
		return em.merge(enr);
	}
}
