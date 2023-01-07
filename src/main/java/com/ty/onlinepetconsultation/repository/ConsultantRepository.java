package com.ty.onlinepetconsultation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.onlinepetconsultation.dto.Consultant;

public interface ConsultantRepository extends JpaRepository<Consultant, Integer>{

	Optional<Consultant> findByEmail(String email);
	
	Optional<Consultant> findByPhone(long phone);
	
	Optional<Consultant> findByName(String name);
	
}
