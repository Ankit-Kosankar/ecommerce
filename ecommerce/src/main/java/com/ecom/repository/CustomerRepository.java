package com.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>
{
	
}
