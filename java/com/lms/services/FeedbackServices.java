package com.lms.services;

import java.util.List;

import com.lms.entities.Feedback;

	public interface FeedbackServices {
		
	List<Feedback> findByStaff(int staffid);
	
	List<Feedback> findAll();
	
	Feedback save(Feedback feedback) ;
}
