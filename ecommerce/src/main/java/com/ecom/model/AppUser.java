package com.ecom.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class AppUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id" , nullable = false)
	private Long id;
	
	@Column(name = "username" , nullable = false, unique = true)
	private String username;   //check the username when user enters his name not on click
	
	@Column(name = "password" , nullable = false)
	private String password;
	
	@Column(name = "email" , nullable = false ,unique = true)
	private String email;
	
	@Column(name = "first_name" , nullable = false)
	private String firstName;
	
	@Column(name = "last_name" , nullable = false)
	private String lastName;
	
	@Column(name = "mobile_number" , nullable = false , unique = true)
	private String mobileNumber;
	
	@Column(name = "address", nullable = true )
	private String address;
	
	@Column(name = "is_active" , nullable = false)
	private Boolean isActive = true;
	
	@Column(name = "is_user_verified" , nullable = false)
	private Boolean isVerified = false;
	
	@Column(name = "is_email_verified", nullable = false)
	private Boolean isEmailVerified = false ;
	
	@Column(name = "created_date" , nullable = false)
	private LocalDate createdDate;
	
	@Column(name = "created_time" , nullable = false)
	private LocalTime createdTime;
	
	@Column(name = "update_date" , nullable = true)
	private LocalDate updatedDate;
	
	@Column(name = "updated_time" , nullable = true)
	private LocalTime updatedTime;
	
	@ManyToOne //many to one relationship[many user can have one role]
	@JoinColumn(name = "role_id") // Foreign key column in User table
	private Role role; 
	
	@OneToOne(cascade = CascadeType.ALL)
	private Customer customer;
	
}
