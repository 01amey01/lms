package com.lms.dtos;

import org.springframework.beans.BeanUtils;

import com.lms.entities.Complaint;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ComplaintDto {
	
	private int id;
	private String complaint;
	private int studentId;

	public static ComplaintDto fromEntity(Complaint comp) {
		ComplaintDto dto = new ComplaintDto();
		BeanUtils.copyProperties(comp, dto);
		return dto;
	}

	public static Complaint toEntity(ComplaintDto dto) {
		Complaint comp = new Complaint();
		BeanUtils.copyProperties(dto, comp);
		return comp;
	}
}
