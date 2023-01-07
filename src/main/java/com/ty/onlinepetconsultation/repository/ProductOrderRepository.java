package com.ty.onlinepetconsultation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.onlinepetconsultation.dto.ProductOrder;
import com.ty.onlinepetconsultation.dto.User;

public interface ProductOrderRepository extends JpaRepository<ProductOrder, Integer> {

	List<ProductOrder> findByUser(User user);
}
