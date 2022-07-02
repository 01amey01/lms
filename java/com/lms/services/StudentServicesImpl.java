package com.lms.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.lms.daos.StudentDao;
import com.lms.entities.Student;

@Transactional
@Service
public class StudentServicesImpl implements StudentServices{
	@Autowired
	StudentDao studentDao;
	
	
	PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	

	@Override
	public List<Student> findAll() {
		return studentDao.findAll();
	}

	@Override
	public void deleteById(int id) {
		studentDao.deleteById(id);
	}

	@Override
	public Student authenticateStudent(String email, String password) {
		return studentDao.findByEmailAndPassword(email, password);
	}
	
	@Override
	public Student save(Student s) {
		return studentDao.save(s);
	}
	@Override
	public Student signUp(Student s) {
		String encodedPassword = passwordEncoder.encode(s.getPassword());
		s.setPassword(encodedPassword);
		return studentDao.save(s);
	}

	@Override
	public Student findById(int id) {
		return studentDao.findById(id);
	}

	@Override
	public Student update(Student stud) {
		return studentDao.save(stud);
	}



	
}
