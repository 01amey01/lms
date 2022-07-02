package com.lms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.dtos.Credentials;
import com.lms.dtos.StaffDto;
import com.lms.entities.Staff;
import com.lms.services.StaffServicesImpl;

@RequestMapping("/admin")
@RestController
public class AdminController {
	@Autowired
	StaffServicesImpl staffService;
	
	public AdminController() {
		System.out.println("Controller :   " + getClass().getName());
     }
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateStaff(@RequestBody Credentials cred) {
		
		return new ResponseEntity<>(staffService.authenticateStaff(cred.getEmail(), cred.getPassword()), HttpStatus.OK);
	}


	@PostMapping("/signup")
	public ResponseEntity<?> saveadmin(StaffDto admin) {
		System.out.println(admin);
		Staff staff= StaffDto.toEntity(admin);
		System.out.println(staff);
		staffService.save(staff);
		
		return  new ResponseEntity<>( staff, HttpStatus.OK);
	}
}
