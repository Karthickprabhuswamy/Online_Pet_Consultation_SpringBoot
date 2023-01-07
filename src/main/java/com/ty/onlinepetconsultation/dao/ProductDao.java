package com.ty.onlinepetconsultation.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.onlinepetconsultation.dto.Product;
import com.ty.onlinepetconsultation.repository.ProductRepository;

@Repository
public class ProductDao {

	@Autowired
	private ProductRepository productRepository;

	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	public Product getProductById(int id) {
		Optional<Product> product = productRepository.findById(id);
		if (product.isPresent()) {
			return product.get();
		} else {
			return null;
		}
	}

	public void deleteProduct(Product product) {
		productRepository.delete(product);
		}
	
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
		

	}


