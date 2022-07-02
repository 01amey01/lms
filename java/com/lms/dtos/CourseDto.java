package com.lms.dtos;


import org.springframework.beans.BeanUtils;

import com.lms.entities.Course;
import com.lms.entities.Staff;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class CourseDto {
	
	
	
	private int id;
	
	private String name;

	private String description;

	private String duration;
	
	private double fees;
	
	private String syllabus;
	
	private int isActive;

	private String image;
	
	private int staff;
	
	
	
	
	
	
	public static CourseDto fromEntity(Course course) {
		CourseDto dto = new CourseDto();
		BeanUtils.copyProperties(course, dto);
		return dto;
	}
	
	// called from POST, PUT
	public static Course toEntity(CourseDto dto, Staff staff ) {
		Course course = new Course();
		course.setName(dto.getName());
		course.setDescription(dto.getDescription());
		course.setDuration(dto.getDuration());
		course.setFees(dto.getFees());
		course.setIsActive(dto.isActive);
		course.setSyllabus(dto.getSyllabus());
		course.setStaff(staff);
		return course;
	}

}
