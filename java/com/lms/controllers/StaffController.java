package com.lms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.dtos.Response;
import com.lms.dtos.StaffDto;
import com.lms.entities.Feedback;
import com.lms.entities.Staff;
import com.lms.services.FeedbackServices;
import com.lms.services.StaffServices;

@CrossOrigin(originPatterns = "*")
@RequestMapping("/instructors")
@RestController
public class StaffController {
	
	@Autowired
	FeedbackServices feedService;
	
	@Autowired
	StaffServices staffService;
	
	public StaffController() {
		System.out.println("Controller :   " + getClass().getName());
     }
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findStaffById(@PathVariable("id") int id){
		
		Staff staff = staffService.findById(id);
		return Response.success(staff);
	}
	
	@GetMapping("")
	public ResponseEntity<?> findStaffAll() {
		List<Staff> list = staffService.findAll();	
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Staff> update(@PathVariable("id") int id, @RequestBody StaffDto staffDato) {
		staffDato.setId(id);
		Staff staff = staffService.findById(id);
		staff.setName(staffDato.getName());
		staff.setMobile(staffDato.getMobile());
		Staff modStaff = staffService.update(staff);
		return new ResponseEntity<>(modStaff, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		staffService.deleteById(id);
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
	
	@GetMapping("/feedback/{id}")
	public ResponseEntity<?> findAllFeedbacks(@PathVariable("id") int id){
		List<Feedback> list = feedService.findByStaff(id);
		
		
		return Response.success(list);
	}
	
	
	
}
