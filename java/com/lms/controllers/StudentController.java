package com.lms.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.dtos.ComplaintDto;
import com.lms.dtos.CourseCardDto;
import com.lms.dtos.CourseDto;
import com.lms.dtos.FeedbackDto;
import com.lms.dtos.Response;
import com.lms.dtos.StudentDto;
import com.lms.entities.Complaint;
import com.lms.entities.Course;
import com.lms.entities.Feedback;
import com.lms.entities.Student;
import com.lms.services.ComplaintServices;
import com.lms.services.CourseServices;
import com.lms.services.FeedbackServices;
import com.lms.services.StaffServices;
import com.lms.services.StudentServices;

@CrossOrigin(originPatterns = "*")
@RequestMapping("/student")
@RestController
public class StudentController {
	@Autowired
	StaffServices staffService;

	@Autowired
	StudentServices studentService;
	
	@Autowired
	CourseServices courseService;
	
	@Autowired
	FeedbackServices feedbackService;
	
	@Autowired
	ComplaintServices complaintService;
	
	StudentController () {
		System.out.println("Controller :   " + getClass().getName());
	}
	

//	@GetMapping("/staff/{id}")
//	public String findStaffById(@PathVariable("id") int id) {
//		Staff staff = staffService.findById(id);
//		// changes to be done
//		return "forward:addfeedback";
//	}
	
	

	@GetMapping("")
	public ResponseEntity<?> findStudentAll() {
		List<Student> list = studentService.findAll();
//		List<StudentDto> result = new ArrayList<StudentDto>();
//		for (Student stud : list)
//			result.add(StudentDto.fromEntity(stud));
		return Response.success(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findStudentById(@PathVariable("id") int id) {
		Student stud = studentService.findById(id);
		StudentDto result = StudentDto.fromEntity(stud);
		return Response.success(result);
	}

	@PutMapping("/{id}/{courseId}")
	public ResponseEntity<?> enrollCourse(@PathVariable("id") int id,@PathVariable("courseId") int courseId) {
		Student stud = studentService.findById(id);
		System.out.println(stud);
		List<Course> courseList =  stud.getEnrolledCourseList();
		Course course = courseService.findById(courseId);
		System.out.println(course);
		courseList.add(course);
        stud.setEnrolledCourseList(courseList);
		studentService.update(stud);
		return Response.success("success");
	}
	
	@GetMapping("/enrolledcourses/{id}")
	public ResponseEntity<?> findCourseByStudentId(@PathVariable("id") int id) {
		Student stud = studentService.findById(id);
		List<Course> courseList = stud.getEnrolledCourseList();
		List<CourseDto> courseDtoList = new ArrayList<>();
		for (Course course : courseList) {
			CourseDto courseDto = new CourseDto();
			courseDto.setId(course.getId());
			courseDto.setName(course.getName());
			courseDto.setDescription(course.getDescription());
			courseDto.setFees(course.getFees());
			courseDto.setSyllabus(course.getSyllabus());
			courseDto.setStaff(course.getStaff().getId());
			courseDto.setIsActive(course.getIsActive());
			courseDtoList.add(courseDto);
		}
		return Response.success(courseDtoList);
	}
	
	@GetMapping("/enrolledcourses/card/{id}")
	public ResponseEntity<?> findCourseCardByStudentId(@PathVariable("id") int id) {
		Student stud = studentService.findById(id);
		List<Course> courseList = stud.getEnrolledCourseList();
		List<CourseCardDto> courseCard = new ArrayList<>();
		for (Course course : courseList) {
			CourseCardDto newCourse = new CourseCardDto();
			newCourse.setId(course.getId());
			newCourse.setTitle(course.getName());
			newCourse.setText(course.getDescription());
			courseCard.add(newCourse);
		}
		 return Response.success(courseCard);
	}


	

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable("id") int id) {
		studentService.deleteById(id);
		return ResponseEntity.ok("Success");
	}
	
	@PostMapping("/addfeedback")
	public ResponseEntity<?> addFeedback(@RequestBody FeedbackDto f) {
		Feedback feed = new Feedback();
		feed = FeedbackDto.toEntity(f);
		//feedbackService.addFeed(feed.getFeedback(), feed.getStaffId(), feed.getStudentId());
		Feedback feedback = feedbackService.save(feed);
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("status", "success");
		result.put("data", feedback);
		return ResponseEntity.ok(result);
	}
	
	@PostMapping("/addcomplaint")
	public ResponseEntity<?> addComplaint(@RequestBody ComplaintDto comp) {
		System.out.println(comp);
		Student stud=studentService.findById(comp.getStudentId());
		Complaint entity=new Complaint();
		entity.setComplaint(comp.getComplaint());
		entity.setStudent(stud);
		Complaint comp2=complaintService.save(entity);
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("status", "success");
		result.put("data", comp2.getComplaint());
		return ResponseEntity.ok(result);
	}

}
