package com.lms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity @Getter @Setter @ToString
@Table(name = "complaint")
public class Complaint {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="complaint_id")
	private int id;
	
	private String complaint;
	
	// many to one unidirectional association
	//requirement - show  all complaints with student (at admin side)
	
	@ManyToOne //(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_no") // student_no is FK column in complaint table.
	private Student student;
	
	public Complaint() {
		this.student = new Student();
	}
	
	public Complaint(int id, String complaint) {
		this.id = id;
		this.complaint = complaint;
		this.student = new Student();
	}
	
	public Complaint(int id, String complaint, Student student) {
		this.id = id;
		this.complaint = complaint;
		this.student = student;
	}
	
	

}
