package com.ecom.service;

import com.ecom.model.AppUser;
import com.ecom.request.UserRegistrationRequest;

public interface AppUserService {

	AppUser createUser(UserRegistrationRequest userRegistrationRequest);

}
