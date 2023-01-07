package com.ty.onlinepetconsultation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.onlinepetconsultation.dto.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	
	
}
