package com.ecom.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "product_sub_category")
public class ProductSubCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String productSubType;
	
	private String productSubTypeDescription;
	
	private LocalDateTime createdOn;
	
	private LocalDateTime updatedOn;
	
	@ManyToMany(mappedBy = "productSubCategory")
	private Set<ProductCategory> productSubcategories = new HashSet<>();

	
}
