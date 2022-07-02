package com.lms.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.entities.Staff;

public interface StaffDao extends JpaRepository<Staff, Integer> {
	
	Staff findByEmailAndPassword(String email , String password);
	
	Staff findById(int id);
}
