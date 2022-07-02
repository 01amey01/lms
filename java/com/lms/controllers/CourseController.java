package com.lms.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.daos.StaffDao;
import com.lms.dtos.CourseDto;
import com.lms.dtos.CourseInDto;
import com.lms.dtos.Response;
import com.lms.entities.Course;
import com.lms.entities.Staff;
import com.lms.services.CourseServicesImpl;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("/courses")
public class CourseController  {
	
	@Autowired
	StaffDao staffDao;
	
	@Autowired
	CourseServicesImpl courseService;
	
	CourseController () {
		System.out.println("Controller :   " + getClass().getName());
	}
	
	
	@GetMapping("")
	public ResponseEntity<?> findAll() {
		List<Course> listCourse = courseService.findAll();
		List<CourseDto> courseDtoList = new ArrayList<>();
		
		for (Course course : listCourse) {
			CourseDto courseDto = new CourseDto();
			courseDto.setId(course.getId());
			courseDto.setName(course.getName());
			courseDto.setDescription(course.getDescription());
			courseDto.setFees(course.getFees());
			courseDto.setDuration(course.getDuration());
			courseDto.setSyllabus(course.getSyllabus());
			courseDto.setStaff(course.getStaff().getId());
			courseDto.setIsActive(course.getIsActive());
			courseDtoList.add(courseDto);
		}
		return Response.success(courseDtoList);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") int id) {
		 Course course = courseService.findById(id);
		return Response.success(course);
	}
	
	@PutMapping("/course/updateCourse")
	public ResponseEntity<?> updateAssignment(CourseInDto updatecourse) {
		Course course = courseService.findById(updatecourse.getId());
		course.setDuration(updatecourse.getDuration());
		course.setFees(updatecourse.getFees());
		courseService.save(course);
		return new ResponseEntity<>(course, HttpStatus.OK);
	}

	
//	@PostMapping("/addCourse")
//	public ResponseEntity<?> addCourseByAdmin( CourseDto dto ) {
//		Staff staff = staffDao.findById(dto.getStaff());
//		System.out.println(staff);
//		 Course course = courseService.save(CourseDto.toEntity(dto,staff));
//		return Response.success(course);
//		
//	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCourseByAdmin(@PathVariable("id") int id) {
		String result = courseService.deleteById((Integer)id);
		
		return Response.success(result);
	}
	
	@GetMapping("/courses")
	public ResponseEntity<?> findAllWithImg() {
		List<Course> listCourse = courseService.findAll();
		if(listCourse!=null)
			return Response.success(listCourse);
		return Response.error(listCourse);
	}
	
	@PostMapping("/addCourse")
	public ResponseEntity<?> save(CourseInDto courseDto) {
		Staff staff = staffDao.findById(courseDto.getStaff());
		System.out.println("Staff: " + staff);
		 Course course = courseService.saveCourse((CourseInDto.toEntity(courseDto,staff)),courseDto.getImage());
		return Response.success(course);
	}

	
	
	

}
