package com.ecom.request;

import java.io.Serializable;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRegistrationRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull
	private String username;
	
	@NotNull
	@Email
	private String email;

	@NotNull
	@Size(min = 6, max = 20)
	private String password;

	@NotNull
	private String firstName;

	@NotNull
	private String lastName;
	
	
}
