package com.lms.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lms.daos.CourseDao;
import com.lms.entities.Course;
import com.lms.entities.Staff;

@Transactional
@Service
public class CourseServicesImpl implements CourseServices{
	@Autowired
	CourseDao courseDao;
	
	@Autowired
	StorageService storageService;

	@Override
	public Course findById(int id) {
		return  courseDao.findById(id).orElse(null) ;
	}

	@Override
	public List<Course> findAll() {
		return courseDao.findAll();
	}

	@Override
	public Course save(Course course) {
		return courseDao.save(course);
	}

	@Override
	public String deleteById(Integer id) {
		if(id != null) {
	       courseDao.deleteById(id);
	       return "Course deleted successfully";
		}
		else {
			return "Id not found!!";
		}
	}
	
	@Override
	public Course findByStaff(Staff staff) {
		return courseDao.findByStaff(staff);
	}

	public Course saveCourse(Course course, MultipartFile image) {
		String fileName = storageService.store(image);
		course.setImage(fileName);
		return courseDao.save(course);
	}
	
}
