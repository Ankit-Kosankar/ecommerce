package com.ecom.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.model.AppUser;
import com.ecom.request.UserRegistrationRequest;
import com.ecom.response.HttpResponse;
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
	
	
}
