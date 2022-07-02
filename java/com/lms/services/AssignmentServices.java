package com.lms.services;

import java.util.List;



import com.lms.entities.Assignment;

public interface AssignmentServices {
	
	 Assignment findById(int id) ;
	 Assignment save(Assignment assignment) ;
	 void deleteById(int id);
	 List<Assignment> findByCourse(int courseNo);
	 List<Assignment> findByStudentId(int id);
//	List<Assignment> findDistinctByCourse(int courseNo);
	List<Assignment> findByCourseUnique(int courseNo);
	
}
