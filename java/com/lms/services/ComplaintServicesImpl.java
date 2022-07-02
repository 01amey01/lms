package com.lms.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.daos.ComplaintDao;
import com.lms.entities.Complaint;

@Transactional
@Service
public class ComplaintServicesImpl implements ComplaintServices{
	@Autowired
	ComplaintDao complaintDao;
	
	@Override
	public List<Complaint> findAll() {
		return complaintDao.findAll();
	}

	@Override
	public Complaint save(Complaint c) {
		return complaintDao.save(c);
	}

	@Override
	public void deleteById(int id) {
		complaintDao.deleteById(id);
	}

}
