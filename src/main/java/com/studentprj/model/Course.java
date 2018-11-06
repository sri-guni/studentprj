package com.studentprj.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="find_all_courses", query="select c from Course c")
public class Course {
	@Id
	private int crsId;
	private String crsName;
	private float actFee;

	public Course() {}
	
	public Course(int crsId, String crsName, float actFee) {
		super();
		this.crsId = crsId;
		this.crsName = crsName;
		this.actFee = actFee;
	}
	public int getCrsId() {
		return crsId;
	}
	public void setCrsId(int crsId) {
		this.crsId = crsId;
	}
	public String getCrsName() {
		return crsName;
	}
	public void setCrsName(String crsName) {
		this.crsName = crsName;
	}
	public float getActFee() {
		return actFee;
	}
	public void setActFee(float actFee) {
		this.actFee = actFee;
	}
}
