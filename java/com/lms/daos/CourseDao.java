package com.lms.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.entities.Course;
import com.lms.entities.Staff;

public interface CourseDao extends JpaRepository<Course,Integer>{

	Course findByStaff(Staff staff);
	
	

}
