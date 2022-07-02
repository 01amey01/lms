package com.lms.services;


import java.util.List;

import com.lms.entities.Complaint;



public interface ComplaintServices {

	List<Complaint> findAll();
	Complaint save(Complaint c); 
	void deleteById(int id);
}
