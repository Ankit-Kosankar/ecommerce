package com.ecom.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String productId;
	
	private String productName;
	
	@ManyToOne
	@JoinColumn(name = "product_category")
	private ProductCategory productCategory;
	
//	@ManyToOne
//	private ProductSub productSubType;
	
	private String productDescription;
	
	private BigDecimal productPrice;
	
	private Integer productQuantity;
	
	private String brand;
	
	private String imageUrl;
	
	private Boolean availablity;
	
	private LocalDateTime  createdOn;
	
	private LocalDateTime updatedOn;
	
	private Integer openingStock;
	
	private Integer closingStcok;
	
	private Integer availableQuantity;
	
}
