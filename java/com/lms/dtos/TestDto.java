package com.lms.dtos;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import com.lms.entities.Test;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class TestDto {
	
	private String testName;
	
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date endDate;
	
	private int studentNo;
	
	private int courseNo;
	
	private int marks;
	
	public static Test toEntity(TestDto testDto) {
		Test test=new Test();
		test.setName(testDto.getTestName());
		test.setEndDate(testDto.getEndDate());
		test.setStudentId(testDto.getStudentNo());
		test.setCourseId(testDto.getCourseNo());
		test.setMarks(testDto.getMarks());
		return test;
	}
}
