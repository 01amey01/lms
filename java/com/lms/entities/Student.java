package com.lms.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@Entity
@Table(name="student")
public class Student {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private int id;
	
	@Column(name="student_name")
	private String name;
	
	@Column(name="student_address")
	private String  address;
	
	@Column(name="student_gender")
	private String gender ;
	
	@Temporal(TemporalType.DATE)
	@Column(name="student_dob")
	private Date dob;
	
	@Column(name="student_mobile")
	private String mobile ;
	
	@Column(name="student_password")
	private String password ;
	
	@Column(name="student_email")
	private String email;
	
	@Column(name="student_is_active")
	private boolean studentIsActive ;
	
	
	//many to many bidirectional association
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="student_course",                                          //cascade type
			joinColumns= {@JoinColumn(name = "student_no")},
			inverseJoinColumns = { @JoinColumn(name = "course_no") } )
	private List<Course> enrolledCourseList;
	
	//one(student) to many(staffs_feedback) bidirectional //mapped by student
	
	@OneToMany(mappedBy = "studentId", cascade = CascadeType.ALL)
	private List<Feedback> feedbackList;
	
	//one(student) to many(courses_assignments) bidirectional //mapped by student
	
		@OneToMany(mappedBy = "studentId", cascade = CascadeType.ALL)
		private List<Assignment> assignmentList;
		
		
		//one(student) to many(courses_tests) bidirectional //mapped by student
		
		@OneToMany(mappedBy = "studentId", cascade = CascadeType.ALL)
		private List<Test> testList;
		
		
		public Student() {
			this.studentIsActive = true;
			this.enrolledCourseList = new ArrayList<>();
			this.assignmentList = new ArrayList<>();
			this.testList = new ArrayList<>();
		}

	public Student(int id, String name, String address, String gender, Date dob, String mobile, String password,
			String email) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.gender = gender;
		this.dob = dob;
		this.mobile = mobile;
		this.password = password;
		this.email = email;
	}
	
	
	
	
}
