package com.ecom.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.model.AppUser;
import com.ecom.request.UserRegistrationRequest;
import com.ecom.response.HttpResponse;
import com.ecom.response.PagedResponse;
import com.ecom.service.AppUserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class AppUserController
{

	private AppUserService appUserService;
	public AppUserController(AppUserService appUserService) {
		this.appUserService = appUserService;
	}




	@PostMapping("/create")
	public ResponseEntity<?> createUser(
			@Valid @RequestBody UserRegistrationRequest userRegistrationRequest,
			BindingResult bindingResult)
	{
		
		if(bindingResult.hasFieldErrors())
		{
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			return ResponseEntity.badRequest().body(allErrors);
		}
		else
		{
			AppUser user = appUserService.createUser(userRegistrationRequest);
			Map<String, AppUser> map= new HashMap<>();
			map.put("user", user);
			HttpResponse httpResponse = HttpResponse
			.builder()
			.message("User Created Successfully")
			.devloperMessage("User Has been Saved in the Database")
			.httpStatus(HttpStatus.CREATED)
			.statusCode(HttpStatus.CREATED.value())
			.timeStamp(LocalDateTime.now().toString())
			.data(map)
			.build();
			return ResponseEntity.ok(httpResponse);
		}

	}
	
	@GetMapping()
	public ResponseEntity<?> getAllUsers(
			@RequestParam(value = "page", defaultValue = "0",required = false) int page,
            @RequestParam(value = "size", defaultValue = "10" , required = false) int size,
            @RequestParam(value = "sortBy", defaultValue = "id" , required = false) String sortBy,
            @RequestParam(value = "sortOrder", defaultValue = "ASC" ,required = false) String sortOrder
            )
	{
		PagedResponse<AppUser> allUsers = appUserService.getAllUsers(page,size,sortBy,sortOrder);
		return ResponseEntity.ok(allUsers);
	}
	
}
