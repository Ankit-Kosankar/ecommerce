package com.ecom.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BrandDTO {

	private String brandName;
	
	private String brandDescription;
	
	private String website;
	
	private String logoUrl;
	
	private LocalDateTime createdOn;
	
	private LocalDateTime updatedOn;
	
}
