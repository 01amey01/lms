package com.lms.controllers;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lms.custom_exceptions.UserNotFoundException;
import com.lms.dtos.Credentials;
import com.lms.dtos.Response;
import com.lms.dtos.StaffDto;
import com.lms.dtos.StudentDto;
import com.lms.entities.Staff;
import com.lms.entities.Student;
import com.lms.services.StaffServicesImpl;
import com.lms.services.StudentServicesImpl;

@CrossOrigin(originPatterns = "*")
@RestController
public class UserController {
	
	@Autowired
	StudentServicesImpl studentService;
	
	@Autowired
	StaffServicesImpl staffService;
	
	public UserController() {
		System.out.println("Controller :   " + getClass().getName());
     }
	
	@PostMapping("student/signin")
	public ResponseEntity<?> authenticateStudent(@RequestBody Credentials cred) {
		Student student = studentService.authenticateStudent(cred.getEmail(), cred.getPassword());
		if(student != null )
			return Response.success(student);
		throw new UserNotFoundException("User not found");
	}
	
	@PostMapping("staff/signin")
	public ResponseEntity<?> authenticateStaff(@RequestBody Credentials cred, HttpSession session ) {
		Staff staff = staffService.authenticateStaff(cred.getEmail(), cred.getPassword());
		//session.setAttribute("loggedinStaff", staff.getId());
		if(staff!=null)
			return Response.success(staff);
		throw new UserNotFoundException("User not found");
	}
	
	
	
	@PostMapping("student/signup")
	public ResponseEntity<?> signUpStudent(StudentDto stud) {
		Student s = StudentDto.toEntity(stud);
		
		Student newStud = studentService.signUp(s);
		StudentDto newDto = StudentDto.fromEntity(newStud);
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("status", "success");
		result.put("data", newDto);
		return ResponseEntity.ok(result);
	}
	
	@PostMapping("instructor/signup")
	public ResponseEntity<?> signUpStaff(StaffDto stud) {
		Staff s = StaffDto.toEntity(stud);
		
		Staff newStaff = staffService.save(s);
		StaffDto newDto = StaffDto.fromEntity(newStaff);
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("status", "success");
		result.put("data", newDto);
		return ResponseEntity.ok(result);
	}

	
	
	
}
