package com.ecom.serviceimpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ecom.model.AppUser;
import com.ecom.repository.AppUserRepository;
import com.ecom.request.UserRegistrationRequest;
import com.ecom.response.PagedResponse;
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
		convertToAppUserEntity.setCreatedDate(LocalDate.now());
		convertToAppUserEntity.setCreatedTime(LocalTime.now());
		convertToAppUserEntity.setIsActive(true);
		convertToAppUserEntity.setIsVerified(false);
		return appUserRepository.save(convertToAppUserEntity);
	}
	
	public AppUser convertToAppUserEntity(UserRegistrationRequest userRegistrationRequest)
	{
		return modelMapper.map(userRegistrationRequest,AppUser.class);
	}

	@Override
	public PagedResponse<AppUser> getAllUsers(int page, int size, String sortBy, String sortOrder) 
	{	                
		Pageable pageRequest1 = PageRequest.of(
	                        page,
	                        size,
	                        Optional.ofNullable(sortOrder)
	                                .filter(order -> order.equalsIgnoreCase("DESC"))
	                                .map(order -> Sort.by(Sort.Order.desc(sortBy)))
	                                .orElse(Sort.by(sortBy))
	                );
		
		Page<AppUser> users = appUserRepository.findAll(pageRequest1);
		PagedResponse<AppUser> pageResponse = new PagedResponse<>();
		pageResponse.setContent(users.getContent());
		pageResponse.setLastPage(users.isLast());
		pageResponse.setTotalPageCount(users.getTotalElements());
		return pageResponse;
	}
	
	
//	Pageable pageRequest2 = PageRequest.of(
//            page,
//            size,
//            Optional.ofNullable(sortOrder)
//                    .filter(order -> order.equalsIgnoreCase("DESC"))
//                    .map(order -> Sort.by(sortBy).descending())
//                    .orElse(Sort.by(sortBy).ascending())
//    );

}
