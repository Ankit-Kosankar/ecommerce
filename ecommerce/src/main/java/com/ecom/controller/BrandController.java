package com.ecom.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.dto.BrandDTO;
import com.ecom.service.BrandService;

@RestController
public class BrandController {

	
	private final BrandService brandService;
	public BrandController(BrandService brandService) {
		this.brandService = brandService;
	}



	public ResponseEntity<?> addBrand(@RequestBody BrandDTO brandDTO)
	{
		brandService.addBrand(brandDTO);
		return null;
	}
	
}
