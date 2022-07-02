package com.lms.daos;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;


import com.lms.entities.Feedback;

//Transactional
public interface FeedbackDao extends JpaRepository<Feedback,Integer>{
	
	List<Feedback> findByStaffId(int staff_no);
	
//	@Modifying
//	@Query(value = "INSERT INTO feedback(feedback) VALUES(feedback)",nativeQuery = true)
//	void addFeed(String feedback, int staff_no, int student_no);


}
