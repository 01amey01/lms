package com.lms.dtos;

import org.springframework.beans.BeanUtils;

import com.lms.entities.Feedback;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class FeedbackDto {
	private String feedback;
	private int studentno;
	private int staffno;
	
	
	
	public static FeedbackDto fromEntity(Feedback feedEntity) {
		FeedbackDto dto = new FeedbackDto();
		BeanUtils.copyProperties(feedEntity, dto);
		return dto;
	}
	
	// called from POST, PUT
	public static Feedback toEntity(FeedbackDto dto) {
		Feedback feedEntity = new Feedback();
		feedEntity.setFeedback(dto.getFeedback());
		feedEntity.setStudentId(dto.getStudentno());
		feedEntity.setStaffId(dto.getStaffno());
		return feedEntity;
	}
}

