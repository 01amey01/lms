package com.lms.dtos;

import java.util.Date;


import org.springframework.format.annotation.DateTimeFormat;
import com.lms.entities.Assignment;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter@Setter@ToString
public class AssignmentDto {
	
	private String assignmentName;
	
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date endDate;
	
	private int courseNo;
	
	private int studentNo;
	
	private boolean status;
	
	
	public static Assignment toEntity(AssignmentDto assignment) {
		
		Assignment assignmentEntity = new Assignment();
		assignmentEntity.setName(assignment.getAssignmentName());
		assignmentEntity.setEndDate(assignment.getEndDate());
		assignmentEntity.setStudentId(assignment.getStudentNo());
		assignmentEntity.setCourseId(assignment.getCourseNo());
		System.out.println(assignmentEntity);
		return assignmentEntity;
	}
	
}
	
	
