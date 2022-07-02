package com.lms.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.daos.StaffDao;
import com.lms.entities.Staff;

@Transactional
@Service
public class StaffServicesImpl implements StaffServices{
	@Autowired
	StaffDao staffDao;

	@Override
	public Staff authenticateStaff(String email, String password) {
		return staffDao.findByEmailAndPassword(email, password);
	}

	@Override
	public Staff findById(int id) {
		return staffDao.findById(id);
	}
	

	@Override
	public List<Staff> findAll() {
		return staffDao.findAll();
	}

	@Override
	public Staff save(Staff staff) {
		return staffDao.save(staff);
	}

	@Override
	public void deleteById(int id) {
		if(staffDao.existsById(id))
			staffDao.deleteById(id);
	}
	
	@Override
	public Staff update(Staff staff) {
		return staffDao.save(staff);
	}

}



