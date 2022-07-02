package com.lms.dtos;

import org.springframework.beans.BeanUtils;
import org.springframework.web.multipart.MultipartFile;

import com.lms.entities.Course;
import com.lms.entities.Staff;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class CourseInDto {
	
    private int id;
	
	private String name;

	private String description;

	private String duration;
	
	private double fees;
	
	private String syllabus;
	
	private int isActive;

	private MultipartFile image;
	
	private int staff;
	
//	public static Course toEntity(CourseInDto dto) {
//		Course entity = new Course();
//		BeanUtils.copyProperties(dto, entity, "image");
//		return entity;
//	}
	
	public static Course toEntity(CourseInDto dto, Staff staff ) {
		Course course = new Course();
		course.setName(dto.getName());
		course.setDescription(dto.getDescription());
		course.setDuration(dto.getDuration());
		course.setFees(dto.getFees());
		course.setIsActive(dto.getIsActive());
		course.setSyllabus(dto.getSyllabus());
		course.setStaff(staff);
		return course;
	}
	
}
