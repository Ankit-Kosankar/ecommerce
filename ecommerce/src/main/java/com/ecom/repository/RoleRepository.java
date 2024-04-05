package com.ecom.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.enums.RoleEnum;
import com.ecom.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>
{

	Optional<Role> findByName(RoleEnum role);

	
}
