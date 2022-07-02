package com.lms.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.daos.TestDao;
import com.lms.entities.Test;

@Transactional
@Service
public class TestServicesImpl implements TestServices{
	
	@Autowired
	TestDao testDao;
	
	@Override
	public Test findById(int id) {
		// TODO Auto-generated method stub
		return testDao.findById(id);
	}


	@Override
	public Test save(Test test) {
		
		return testDao.save(test);
	}

	@Override
	public void deleteById(int id) {
		
		testDao.deleteById(id);
	}
	
	@Override
	public List<Test> findByCourse(int course_no) {
		
		return testDao.findByCourseId(course_no);
	}
	
	@Override
	public List<Test> findByStudentId(int student_no) {
		
		return testDao.findByStudentId(student_no);
	}



	
}
