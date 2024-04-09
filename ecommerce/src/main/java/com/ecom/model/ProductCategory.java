package com.ecom.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "product_category")
public class ProductCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String category;
	
	
	@ManyToMany
	@JoinTable(name = "category_subcategory",
	            joinColumns = @JoinColumn(name = "subcategory_id"),
	            inverseJoinColumns = @JoinColumn(name = "category_id"))
	private Set<ProductSubCategory> productSubCategory = new HashSet<>();
	
	private String productType;
	
	private String productDescription;
	
	private LocalDateTime createdOn;
	
	private LocalDateTime updatedOn;
	
	@OneToMany(mappedBy = "productCategory",fetch = FetchType.EAGER) // One-to-Many relationship from Role to User (optional - for fetching users with a role)
	@JsonBackReference
	private List<Product> allProducts;
	
}
