package com.studentprj.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Enrollments {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int txId;
	private int crsId;
	private int studId;
	private float feePaid;
	private String startDate;
	
	public Enrollments() {};
	public Enrollments(int crsId, int studId, float feePaid, String startDate) {
		super();
		this.crsId = crsId;
		this.studId = studId;
		this.feePaid = feePaid;
		this.startDate = startDate;
	}
	public int getTxId() {
		return txId;
	}
	public void setTxId(int txId) {
		this.txId = txId;
	}
	public int getCrsId() {
		return crsId;
	}
	public void setCrsId(int crsId) {
		this.crsId = crsId;
	}
	public int getStudId() {
		return studId;
	}
	public void setStudId(int studId) {
		this.studId = studId;
	}
	public float getFeePaid() {
		return feePaid;
	}
	public void setFeePaid(float feePaid) {
		this.feePaid = feePaid;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}	
}
