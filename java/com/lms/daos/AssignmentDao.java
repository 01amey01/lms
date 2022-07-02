package com.lms.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.entities.Assignment;

public interface AssignmentDao extends JpaRepository<Assignment, Integer> {
	
	
	List<Assignment> findByCourseId(int id);
	
	
//	@Query(value = "select distinct assignment_name ,created_assignment, end_assignment from assignment where course_no=course_no",nativeQuery = true)
//	List<Assignment>findDistinctByCourse(int course_no);
	
	 Assignment findById(int id);
	 
	List<Assignment> findByStudentId(int student_no);
	 

}
