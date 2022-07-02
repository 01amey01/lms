package com.lms.exception_handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.lms.custom_exceptions.UserNotFoundException;
import com.lms.dtos.Response;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<?> userNotFoundhandler ( UserNotFoundException e ) {
		return Response.error("Wrong Credentials");
	}
	
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<?>HandlingException(Exception e)
//	{
//		System.out.println("in handle acct exc");
//		return Response.error("SERVER SIDE ERROR!!!");
//	}
}
