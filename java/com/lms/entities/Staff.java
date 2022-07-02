package com.lms.entities;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity @Getter @Setter @NoArgsConstructor @ToString
@Table(name = "staff")
public class Staff {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "staff_id")
	private int id;
	
	@Column(name = "staff_name")
	private String name;
	
	@Column(name = "staff_mobile")
	private String mobile;
	
	@Column(name = "staff_email")
	private String email;
	
	@Column(name = "staff_password")
	private String password;
	
	@Enumerated(EnumType.STRING)		// Specifies the Role as String data-type in database 
	private Role role;
	
	private Double earning;
	
	//one(staff) to many(students_feedback) bidirectional //mapped by staff
	
	@OneToMany(mappedBy = "staffId", cascade = CascadeType.ALL)
	private List<Feedback> feedbackList;
	
	public Staff(int id, String name, String mobile, String email, String password, Role role, Double earning) {
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
		this.role = role;
		this.earning = earning;
	}
	
	
	
	
	
	

}
