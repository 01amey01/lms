package com.lms.dtos;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString
public class TestCalendarDto {
private String title;
	
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date date;
}

