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
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity @Getter @Setter @NoArgsConstructor @ToString 
@Table(name = "assignment")
public class Assignment {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "assignment_id")
	private int id;
	
	@Column(name = "assignment_name")
	private String name;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_assignment", insertable = false, updatable = false)
	private Date createdDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_assignment")
	private Date endDate;
	
	@Column(name = "completion_status")
	private boolean status;
	
	private int marks;

	@Column(name="student_no") 
	private int studentId;
	
	@Column(name="course_no")
	private int courseId;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Assignment other = (Assignment) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	


	
	
	
	
	


}
