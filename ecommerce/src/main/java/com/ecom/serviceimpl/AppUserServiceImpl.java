package com.ecom.serviceimpl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ecom.model.AppUser;
import com.ecom.repository.AppUserRepository;
import com.ecom.request.UserRegistrationRequest;
import com.ecom.service.AppUserService;

@Service
public class AppUserServiceImpl implements AppUserService{

	private final ModelMapper modelMapper;
	private final AppUserRepository appUserRepository;
	public AppUserServiceImpl(AppUserRepository appUserRepository) {
		this.appUserRepository = appUserRepository;
		this.modelMapper = new ModelMapper();
	}

	@Override
	public AppUser createUser(UserRegistrationRequest userRegistrationRequest)
	{
		AppUser convertToAppUserEntity = convertToAppUserEntity(userRegistrationRequest);
		return appUserRepository.save(convertToAppUserEntity);
	}
	
	public AppUser convertToAppUserEntity(UserRegistrationRequest userRegistrationRequest)
	{
		return modelMapper.map(userRegistrationRequest,AppUser.class);
	}

}
