package com.lms.dtos;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import com.lms.entities.Student;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StudentDto {
	private String name;
	private String address;
	private String gender;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dob;
	private String mobile;
	private String password;
	private String email;

	public static StudentDto fromEntity(Student b) {
		StudentDto dto = new StudentDto();
		BeanUtils.copyProperties(b, dto);
		return dto;
	}

	public static Student toEntity(StudentDto dto) {
		Student b = new Student();
		BeanUtils.copyProperties(dto, b);
		return b;
	}


}
