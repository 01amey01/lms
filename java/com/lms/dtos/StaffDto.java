package com.lms.dtos;

import org.springframework.beans.BeanUtils;

import com.lms.entities.Role;
import com.lms.entities.Staff;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@ToString
public class StaffDto {
	private int id;
	private String name;
	private String mobile;
	private String email;
	private String password;
	private Role role;
	private double earning;

	public static StaffDto fromEntity(Staff b) {
		StaffDto dto = new StaffDto();
		BeanUtils.copyProperties(b, dto);
		return dto;
	}

	public static Staff toEntity(StaffDto dto) {
		Staff b = new Staff();
		BeanUtils.copyProperties(dto, b);
		return b;
	}


}
