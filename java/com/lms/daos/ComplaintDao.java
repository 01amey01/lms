package com.lms.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.entities.Complaint;

public interface ComplaintDao extends JpaRepository<Complaint,Integer> {

}
