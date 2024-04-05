package com.ecom.model;

import java.util.List;

import com.ecom.enums.RoleEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "role")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private RoleEnum name;

	 @OneToMany(mappedBy = "role",fetch = FetchType.EAGER) // One-to-Many relationship from Role to User (optional - for fetching users with a role)
	 @JsonIgnoreProperties("role") //// Exclude the 'users' collection
	 @JsonBackReference
	 private List<AppUser> users;
	// Constructors, getters, and setters
	
}
