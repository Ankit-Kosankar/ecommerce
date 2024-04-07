package com.ecom.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.ecom.model.Customer;
import com.ecom.model.Role;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class AppUserDTO {

	private Long id;
	
	private String username;   //check the username when user enters his name not on click
	
	
	private String password;
	
	
	private String email;
	
	
	private String firstName;
	
	private String lastName;
	
	
	private String mobileNumber;
	
	
	private String address;
	
	
	private Boolean isActive = true;
	
	
	private Boolean isVerified = false;
	
	
	private Boolean isEmailVerified = false ;
	
	
	private LocalDate createdDate;
	
	
	private LocalTime createdTime;
	
	
	private LocalDate updatedDate;
	
	
	private LocalTime updatedTime;
	
	
	private Role role; 
	
	
	private Customer customer;
	
}
