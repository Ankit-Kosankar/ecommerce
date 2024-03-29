package com.ecom.request;

import java.io.Serializable;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LoginRequest implements Serializable
{

	private static final long serialVersionUID = 1L;

	@NotNull
	private String username;
	
	@NotNull
	private String password;
}
