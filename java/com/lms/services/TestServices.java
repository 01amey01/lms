package com.lms.services;

import java.util.List;

import com.lms.entities.Test;

public interface TestServices {

	Test save(Test test);
	void deleteById(int id);
	List<Test> findByCourse(int course_no);
	List<Test> findByStudentId(int student_no);
	Test findById(int id);
}
