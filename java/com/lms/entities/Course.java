package com.lms.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity @Getter @Setter @NoArgsConstructor @ToString
@Table(name = "course")
public class Course{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_id")
	private int id;
	
	@Column(name = "course_name")
	private String name;

	@Column(name = "course_description")
	private String description;

	@Column(name = "course_duration")
	private String duration;
	
	@Column(name = "course_fees")
	private double fees;
	
	@Column(name = "course_syllabus")
	private String syllabus;
	
	@Column(name = "course_is_active")
	private int isActive;
	
	@Column(name = "cover_photo")
	private String image;
	
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@Temporal(TemporalType.TIMESTAMP )
	@Column(name = "created_course", insertable = false, updatable = false)
	private Date startDate;
	
	@OneToOne
	@JoinColumn(name="staff_no")
	private Staff staff;
	
//	//many to many bidirectional association
//	
//	@ManyToMany(mappedBy = "enrolledCourseList", cascade = CascadeType.ALL)  //add cascade type
//	private List<Student> enrolledStudentList;
	
	//one(course) to many(students_assignments) bidirectional //mapped by course
	
	@OneToMany(mappedBy = "courseId", cascade = CascadeType.ALL)
	private List<Assignment> assignmentList;
	
	
	//one(course) to many(students_tests) bidirectional //mapped by course
	
	@OneToMany(mappedBy = "courseId", cascade = CascadeType.ALL)
	private List<Test> testList;

	public Course(int id, String name, String description, String duration, double fees, String syllabus,
			int isActive, String image, Date startDate) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.duration = duration;
		this.fees = fees;
		this.syllabus = syllabus;
		this.isActive = isActive;
		this.image = image;
		this.startDate = startDate;
	}
	
	
	
	
	
	
	
	

}
