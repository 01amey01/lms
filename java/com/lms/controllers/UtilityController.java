package com.lms.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.lms.dtos.AssignmentCalendarDto;
import com.lms.dtos.AssignmentDto;
import com.lms.dtos.ComplaintDto;
import com.lms.dtos.Response;
import com.lms.dtos.TestCalendarDto;
import com.lms.dtos.TestDto;
import com.lms.entities.Assignment;
import com.lms.entities.Complaint;
import com.lms.entities.Course;
import com.lms.entities.Staff;
import com.lms.entities.Student;
import com.lms.entities.Test;
import com.lms.services.AssignmentServicesImpl;
import com.lms.services.ComplaintServices;
import com.lms.services.CourseServices;
import com.lms.services.StaffServices;
import com.lms.services.StudentServices;
import com.lms.services.TestServices;

@CrossOrigin(originPatterns = "*")
@RequestMapping("/activity")
@RestController
public class UtilityController {
	@Autowired
	AssignmentServicesImpl assignmentService;
	@Autowired
	TestServices testService;
	
	@Autowired
	StaffServices staffService;

	@Autowired
	StudentServices studentService;
	
	@Autowired
	ComplaintServices compService;
	
	@Autowired
	CourseServices courseServices;
	
	public UtilityController() {
		System.out.println("Controller :   " + getClass().getName());
     }
	
	@GetMapping("/student/assignment/{id}")
	public ResponseEntity<?> findAssignmentByStudentId(@PathVariable("id") int id) {
		List<Assignment> assignment = assignmentService.findByStudentId(id);
		List<Assignment> list=new ArrayList<Assignment>();
		for (Assignment singleAssignment : assignment) {
			list.add(singleAssignment);
		}
		return Response.success(list);
	}
	
	@GetMapping("/course/assignment/{id}")
	public ResponseEntity<?> findAssignmentByCourseId(@PathVariable("id") int id ) {
		Staff staff = staffService.findById(id);
		Course course =  courseServices.findByStaff(staff);
		List<Assignment> assignments = assignmentService.findByCourse(course.getId());
		return Response.success(assignments);
	}
	
	@GetMapping("/course/assignment/unique/{id}")
	public ResponseEntity<?> findUniqueAssignmentByCourseId(@PathVariable("id") int id ) {
		Staff staff = staffService.findById(id);
		Course course =  courseServices.findByStaff(staff);
		List<Assignment> assignments = assignmentService.findByCourseUnique(course.getId());
		return Response.success(assignments);
	}
//	@GetMapping("/course/assignment")
//	public ResponseEntity<?> findAssignmentByCourseIdSession(HttpSession session) {
//		Integer staffId = (Integer) session.getAttribute("loggedinStaff");
//		System.out.println(staffId);
//		Staff staff = staffService.findById(staffId);
//		Course course =  courseServices.findByStaff(staff);
//		System.out.println(course);
//		List<Assignment> assignments = assignmentService.findByCourse(course.getId());
//		return Response.success(assignments);
//	}
	
	@GetMapping("/course/assignment/calendar/{id}")
	public ResponseEntity<?> findAssignmentByCourseIdCalendar(@PathVariable("id") int id) {
		Staff staff = staffService.findById(id);
		Course course =  courseServices.findByStaff(staff);
		List<Assignment> assignments = assignmentService.findByCourse(course.getId());
		List<AssignmentCalendarDto> calendarDto = new ArrayList<>();
		for (Assignment assignment : assignments) {
			AssignmentCalendarDto calendar = new AssignmentCalendarDto();
			calendar.setTitle(assignment.getName());
			calendar.setDate(assignment.getEndDate());
			calendarDto.add(calendar);
		}
		return Response.success(calendarDto);
	}
//	@GetMapping("/course/assignment/calendar")
//	public ResponseEntity<?> findAssignmentByCourseIdCalendar( HttpSession session) {
//		Staff staff = (Staff) session.getAttribute("loggedinStaff");
//		Course course =  courseServices.findByStaff(staff);
//		List<Assignment> assignments = assignmentService.findByCourse(course.getId());
//		List<AssignmentCalendarDto> calendarDto = new ArrayList<>();
//		for (Assignment assignment : assignments) {
//			AssignmentCalendarDto calendar = new AssignmentCalendarDto();
//			calendar.setTitle(assignment.getName());
//			calendar.setDate(assignment.getEndDate());
//			calendarDto.add(calendar);
//		}
//		return Response.success(calendarDto);
//	}
	
	@GetMapping("/course/test/calendar/{id}")
	public ResponseEntity<?> findTestByCourseIdCalendar(@PathVariable("id") int id) {
		Staff staff = staffService.findById(id);
		Course course =  courseServices.findByStaff(staff);
		List<Test> tests = testService.findByCourse(course.getId());
		List<TestCalendarDto> calendarDto = new ArrayList<>();
		for (Test test : tests) {
			TestCalendarDto newTest = new TestCalendarDto();
			newTest.setTitle(test.getName());
			newTest.setDate(test.getEndDate());
			calendarDto.add(newTest);
		}
		return Response.success(calendarDto);
	}

//	@GetMapping("/course/distinctassignment/{id}")
//	public ResponseEntity<?> findDistinctAssignmentByCourseId(@PathVariable("id") int id , HttpSession session) {
//		//Staff staff = (Staff) session.getAttribute("loggedinStaff");
////		Course course =  courseServices.findByStaff(staff);
////		List<Assignment> assignment = assignmentService.findByCourse(course.getId());
//		List<Assignment> assignments = assignmentService.findDistinctByCourse(id);
//		return Response.success(assignments);
//	}
//	
	@GetMapping("/course/test/{id}")
	public ResponseEntity<?> findTestsByCourseId(@PathVariable("id") int id) {
		Staff staff = staffService.findById(id);
		Course course =  courseServices.findByStaff(staff);
		List<Test> tests = testService.findByCourse(course.getId());
		return Response.success(tests);
	}

	
	@PostMapping("/assignment/addAssignment")
	public ResponseEntity<?> addAssignment(@RequestBody AssignmentDto assignment, HttpSession session) {
		//Staff staff = (Staff) session.getAttribute("loggedinStaff");
//		Course course =  courseServices.findByStaff(staff);
		//assignment.setCourseNo(course.getId()); //remove corseno from dto after adding session
		System.out.println(assignment);
		Assignment a= AssignmentDto.toEntity(assignment);
		System.out.println(a);
		Assignment assignmentEntity = assignmentService.save(a);
		return  Response.success(assignmentEntity);
	}
	
	@PutMapping("/assignment/updateAssignment")
	public ResponseEntity<?> updateAssignment(@RequestBody Assignment a) {
		Assignment assi = assignmentService.findById(a.getId());
		System.out.println(assi);
		assi.setMarks(a.getMarks());
		Assignment assignment = assignmentService.save(assi);
		return  Response.success(assignment);
	}
	
	@DeleteMapping("/assignment/{id}")
	public ResponseEntity<?> deleteAssignment(@PathVariable("id") int id) {
		assignmentService.deleteById(id);
		return  Response.success("Success");
	}
	
	@GetMapping("/student/test/{id}")
	public ResponseEntity<?> findTestByStudentId(@PathVariable("id") int id) {
		List <Test> tests= testService.findByStudentId(id);
		return  Response.success(tests);
	}

	
	@PostMapping("/test/addTest")
	public ResponseEntity<?> saveTest(@RequestBody TestDto test) {
		
		System.out.println(test);
		Test testEntity = TestDto.toEntity(test);
		//System.out.println(testEntity);
		Test testAdded = testService.save(testEntity);
		return  Response.success(testAdded);
	}
	
	@PutMapping("/test/updateTest")
	public ResponseEntity<?> updateTest(@RequestBody Test t) {
		Test test = testService.findById(t.getId());
		test.setMarks(t.getMarks());
		Test testChange = testService.save(test);
		return Response.success(testChange);
	}

	

	@DeleteMapping("/test/{id}")
	public ResponseEntity<?> deleteTest(@PathVariable("id") int id) {
		testService.deleteById(id);
		return  new ResponseEntity<>("Success", HttpStatus.OK);
	}
	
	
	@GetMapping("/complaints")
	public ResponseEntity<?> fetchAllComplaint() {
		List<Complaint> list = compService.findAll();
		List<ComplaintDto> result = new ArrayList<>();
		for (Complaint comp : list) {
			Student stud=comp.getStudent();
			int studId=stud.getId();
			ComplaintDto dto=new ComplaintDto();
			dto.setId(comp.getId());
			dto.setComplaint(comp.getComplaint());
			dto.setStudentId(studId);
			//System.out.println(dto);
			result.add(dto);
		}	
		return Response.success(result);
	}
	
	
	@DeleteMapping("/complaint/{id}")
	public ResponseEntity<?> deleteComplaint(@PathVariable("id") int id) {
		compService.deleteById(id);
		return ResponseEntity.ok("success");
	}
	
	
}
