package com.ecom.exception;

public class RoleNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	 public RoleNotFoundException(String roleName) {
	        super("Role '" + roleName + "' not found.");
	    }

}
