package com.ecom.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.model.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand,Integer>
{

	Optional<Brand> findByBrandName(String brandName);
	
	
}
