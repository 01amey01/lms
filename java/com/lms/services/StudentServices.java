package com.lms.services;

import java.util.List;
import com.lms.entities.Student;


public interface StudentServices {
	
	Student authenticateStudent(String email, String password);
	
	Student findById(int id) ;
	
	List<Student> findAll();
	
	Student save(Student student) ;
	
	void deleteById(int id);
	
	Student update(Student stud);

	Student signUp(Student s);
	

}
