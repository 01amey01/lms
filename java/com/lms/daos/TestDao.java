package com.lms.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.entities.Test;

public interface TestDao extends JpaRepository<Test,Integer>{
	
	
	List<Test> findByCourseId(int course_no);

	List<Test> findByStudentId(int student_no);
	
	Test findById(int id);

}
