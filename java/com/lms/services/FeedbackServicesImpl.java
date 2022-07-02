package com.lms.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.daos.FeedbackDao;
import com.lms.entities.Feedback;

@Transactional
@Service
public class FeedbackServicesImpl implements FeedbackServices{
	@Autowired
	FeedbackDao feedbackDao;

	@Override
	public List<Feedback> findByStaff(int staffid) {
		return feedbackDao.findByStaffId(staffid);
	}


	@Override
	public List<Feedback> findAll() {
		return feedbackDao.findAll();
	}


	@Override
	public Feedback save(Feedback feedback) {
		return feedbackDao.save(feedback);
	}
	
	


	
	
}
