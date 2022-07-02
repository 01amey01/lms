package com.lms.services;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.daos.AssignmentDao;
import com.lms.entities.Assignment;

@Transactional
@Service
public class AssignmentServicesImpl implements AssignmentServices {
	@Autowired
	AssignmentDao assignmentDao;

	@Override
	public Assignment findById(int id) {
		return assignmentDao.findById(id);
	}


	@Override
	public void deleteById(int id) {
		
		assignmentDao.deleteById(id);

	}

	@Override
	public List<Assignment> findByCourse(int courseNo) {
		
		return assignmentDao.findByCourseId(courseNo);
	}
	
	@Override
	public List<Assignment> findByCourseUnique(int courseNo) {
		
		List<Assignment> assignments =  assignmentDao.findByCourseId(courseNo);
		
		assignments.forEach(System.out::println);
		
		List<Assignment> uniqueAssignments =  assignments.stream().distinct().collect(Collectors.toList());
		
		System.out.println("unique");
		uniqueAssignments.forEach(System.out::println);
		
		return uniqueAssignments;
	}
	
//	@Override
//	public List<Assignment> findDistinctByCourse(int courseNo) {
//		
//		return assignmentDao.findDistinctByCourse(courseNo);
//	}
	
	@Override
	public Assignment save(Assignment assignment) {
		
		return assignmentDao.save(assignment);
	}

	
	@Override
	public List<Assignment> findByStudentId(int id) {
		return assignmentDao.findByStudentId(id);
	}
	
	
}




