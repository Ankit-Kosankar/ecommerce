package com.ecom.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home
{

	@GetMapping("/")
	public ResponseEntity<?> home()
	{
		Map<String,Object> map = new HashMap<>();
		map.put("description", "THis is a simple Basic Project For E Commerce");
		map.put("message", "Welcome to the Project E-Commerce Project");
		return ResponseEntity.ok(map);
	}
	
}
