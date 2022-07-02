package com.lms.services;

import java.util.List;

import com.lms.entities.Course;
import com.lms.entities.Staff;

public interface CourseServices {

	 Course findById(int id) ;
	
 	 List<Course> findAll();
	
	 Course save( Course c) ;
	
	 String deleteById(Integer id);

	Course findByStaff(Staff staff);
}
