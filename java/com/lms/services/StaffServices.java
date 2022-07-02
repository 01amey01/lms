package com.lms.services;

import java.util.List;


import com.lms.entities.Staff;

public interface StaffServices {
	Staff authenticateStaff(String email, String password); 
	
	Staff findById(int id) ;
	
	List<Staff> findAll();
	
	Staff save(Staff staff) ;
	
	void deleteById(int id);
	
	Staff update(Staff staff);
	
}
