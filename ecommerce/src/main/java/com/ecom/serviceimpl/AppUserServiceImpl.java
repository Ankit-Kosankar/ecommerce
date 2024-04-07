package com.ecom.serviceimpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ecom.dto.AppUserDTO;
import com.ecom.enums.RoleEnum;
import com.ecom.exception.RoleNotFoundException;
import com.ecom.model.AppUser;
import com.ecom.model.Customer;
import com.ecom.model.Role;
import com.ecom.repository.AppUserRepository;
import com.ecom.repository.CustomerRepository;
import com.ecom.repository.RoleRepository;
import com.ecom.request.UserRegistrationRequest;
import com.ecom.response.PagedResponse;
import com.ecom.service.AppUserService;

import jakarta.transaction.Transactional;

@Service
public class AppUserServiceImpl implements AppUserService{

	private final ModelMapper modelMapper;
	private final AppUserRepository appUserRepository;
	private final RoleRepository roleRepository;
	private final CustomerRepository customerRepository;
	
	public AppUserServiceImpl(AppUserRepository appUserRepository
			,RoleRepository roleRepository,
			CustomerRepository customerRepository) {
		this.appUserRepository = appUserRepository;
		this.modelMapper = new ModelMapper();
		this.roleRepository = roleRepository;
		this.customerRepository = customerRepository;
	}

	@Override
	@Transactional
	public AppUser createUser(UserRegistrationRequest userRegistrationRequest)
	{

		Optional<Role> userRole = roleRepository.findByName(RoleEnum.USER);
		if(userRole.isEmpty())
		{
			throw new RoleNotFoundException(RoleEnum.USER.toString());
		}
		else
		{
			Customer customer = convertToCustomerEntity(userRegistrationRequest);
			customer.setCreatedDate(LocalDate.now());
			customer.setCreatedTime(LocalTime.now());
			
			
			AppUser convertToAppUserEntity = convertToAppUserEntity(userRegistrationRequest);
			convertToAppUserEntity.setCreatedDate(LocalDate.now());
			convertToAppUserEntity.setCreatedTime(LocalTime.now());
			convertToAppUserEntity.setIsActive(true);
			convertToAppUserEntity.setIsVerified(false);
			convertToAppUserEntity.setRole(userRole.get());
			convertToAppUserEntity.setCustomer(customer);
			
			customerRepository.save(customer);
			
			return appUserRepository.save(convertToAppUserEntity);
		}
	}
	
	public AppUser convertToAppUserEntity(UserRegistrationRequest userRegistrationRequest)
	{
		return modelMapper.map(userRegistrationRequest,AppUser.class);
	}

	public Customer convertToCustomerEntity(UserRegistrationRequest userRegistrationRequest)
	{
		return modelMapper.map(userRegistrationRequest, Customer.class);
	}
	
	@Override
	public PagedResponse<AppUserDTO> getAllUsers(int page, int size, String sortBy, String sortOrder) 
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
		PagedResponse<AppUserDTO> pageResponse = new PagedResponse<>();
		List<AppUser> listUser = users.getContent();
		List<AppUserDTO> list = listUser
		.stream()
		.map(appUser -> convertAppUserToAppUserDTO(appUser))
		.toList();
		
		pageResponse.setContent(list);
		pageResponse.setLastPage(users.isLast());
		pageResponse.setTotalPageCount(users.getTotalElements());
		return pageResponse;
	}
	
	
	
	public AppUserDTO convertAppUserToAppUserDTO(AppUser appUser)
	{
		return modelMapper.map(appUser, AppUserDTO.class);
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
