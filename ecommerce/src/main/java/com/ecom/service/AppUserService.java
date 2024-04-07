package com.ecom.service;

import com.ecom.dto.AppUserDTO;
import com.ecom.model.AppUser;
import com.ecom.request.UserRegistrationRequest;
import com.ecom.response.PagedResponse;

public interface AppUserService {

	AppUser createUser(UserRegistrationRequest userRegistrationRequest);

	PagedResponse<AppUserDTO> getAllUsers(int page, int size, String sortBy, String sortOrder);

}
