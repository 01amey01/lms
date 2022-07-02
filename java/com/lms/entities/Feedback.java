package com.lms.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity @Getter @Setter @ToString
@Table(name = "feedback")
public class Feedback {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="feedback_id")
	private int id;
	
	private String feedback;
	
	@Column(name = "student_no")
	private int studentId;
	
	@Column(name = "staff_no")
	private int staffId;

}
