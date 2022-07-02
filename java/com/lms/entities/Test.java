package com.lms.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity @Getter @Setter @ToString
@Table(name = "test")
public class Test {
	@Column(name="test_id")
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="test_name")
	private String name;
	
	@Temporal(TemporalType.TIMESTAMP )
	@Column(name = "created_test", insertable = false, updatable = false)
	private Date createdDate;
	
	@Column(name="end_test")
	@Temporal(TemporalType.TIMESTAMP )
	private Date endDate;
	
	
	private int marks;
	
	@Column(name = "completion_status")
	private Boolean complitionStatus;
	
	
	@Column(name="student_no") 
	private int studentId;
	
	
	@Column(name="course_no")
	private int courseId;

	
	
	

}
