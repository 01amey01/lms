package com.lms;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class LmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LmsApplication.class, args);
	}
	
	@Bean
	public HttpSessionListener httpSessionListener() {
	 return new HttpSessionListener() {
	     @Override
	     public void sessionCreated(HttpSessionEvent se) {
	         System.out.println("Session Created with session id+" + se.getSession().getId());
	     }
	     @Override
	     public void sessionDestroyed(HttpSessionEvent se) {
	         System.out.println("Session Destroyed, Session id:" + se.getSession().getId());
	     }
	 };
	}

}
