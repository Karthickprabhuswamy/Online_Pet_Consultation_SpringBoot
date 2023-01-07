package com.ty.onlinepetconsultation.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.onlinepetconsultation.dto.Product;
import com.ty.onlinepetconsultation.dto.ProductOrder;
import com.ty.onlinepetconsultation.repository.ProductOrderRepository;

@Repository
public class ProductOrderDao {

	@Autowired
	private ProductOrderRepository productOrderRepository;

	public ProductOrder saveProductOrder(ProductOrder productOrder) {
		return productOrderRepository.save(productOrder);
	}

	public ProductOrder getProductOrderById(int id) {
		Optional<ProductOrder> optional = productOrderRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}


	  public void deleteProductOrder(ProductOrder order) {
	  
	  productOrderRepository.delete(order); }
	
	public List<ProductOrder> getAllProductOrder() {
		return productOrderRepository.findAll();

	}

}
