package com.studentprj.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="find_all_students", query="select s from Student s")
public class Student {
	@Id
	private int studId;
	private String name;
	private String email;
	private String phone;
	
	public Student() {}
	public Student(int studId, String name, String email, String phone) {
		super();
		this.studId = studId;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
	public int getStudId() {
		return studId;
	}
	public void setStudId(int studId) {
		this.studId = studId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
