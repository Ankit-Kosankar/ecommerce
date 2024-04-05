package com.ecom.request;

import java.io.Serializable;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRegistrationRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "username cannot be null")
	private String username;
	
	@NotNull
	@Email(message = "Email cannot be null")
	private String email;

	@NotNull
	@Size(min = 6, max = 20, message = "The allowed length for password is 6Charcters  to 20character")
	private String password;

	@NotNull
	private String firstName;

	@NotNull
	private String lastName;
	
	@NotNull
	@Size(min = 10, max = 10, message = "Only 10 digits are allowed")
	private String mobileNumber;
	
	
}
