package com.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.model.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long>
{
	
}
