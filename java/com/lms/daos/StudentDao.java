package com.lms.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.entities.Student;

public interface StudentDao extends JpaRepository<Student, Integer> {
	
	Student findByEmailAndPassword(String email , String password);
	
	Student findById(int id);

}
