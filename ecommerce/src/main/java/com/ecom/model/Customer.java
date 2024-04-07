package com.ecom.model;

import java.time.LocalDate;
import java.time.LocalTime;

import com.ecom.enums.GenderEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Customer
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "first_name" , nullable = true)
	private String firstName;
	
	@Column(name = "middle_name" , nullable = true)
	private String middleName;
	
	@Column(name = "username" , nullable = true)
	private String username;
	
	@Column(name = "mobile_number" , nullable = true)
	private String mobileNumber;
	
	@Column(name = "last_name" , nullable = true)
	private String lastName;
	
	//should be List of Address
	@Column(name = "address" , nullable = true)
	private String address;
	
	@Column(name = "date_of_birth" , nullable = true)
	private LocalDate dateOfBirth;
	
	@Column(name = "gender" , nullable = true)
	@Enumerated(EnumType.STRING)
	private GenderEnum gender;
	
	@Column(name = "email" , nullable = false ,unique = true)
	private String email;
	
	@Column(name = "created_date" , nullable = false)
	private LocalDate createdDate;
	
	@Column(name = "created_time" , nullable = false)
	private LocalTime createdTime;
	
	@Column(name = "update_date" , nullable = true)
	private LocalDate updatedDate;
	
	@Column(name = "updated_time" , nullable = true)
	private LocalTime updatedTime;
	
}
