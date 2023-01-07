package com.ty.onlinepetconsultation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.onlinepetconsultation.dao.ProductDao;
import com.ty.onlinepetconsultation.dto.Product;
import com.ty.onlinepetconsultation.dto.ResponseStructure;
import com.ty.onlinepetconsultation.exception.NoIdFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductDao dao;

	public ResponseEntity<ResponseStructure<Product>> saveProducts(Product product) {

		ResponseStructure<Product> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("SUCCESS");
		responseStructure.setData(dao.saveProduct(product));
		return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Product>> updateProduct(Product product) {

		int id = product.getId();

		ResponseStructure<Product> responseStructure = new ResponseStructure<>();
		List<Product> p = dao.getAllProducts();
		int count = 1;

		for (int i = 0; i < p.size(); i++) {
			if (p.get(i).getId() == id) {
				count++;
				break;
			}
		}

		if (count > 1) {
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData(dao.saveProduct(product));
			return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.CREATED);
		}

		else {
			throw new NoIdFoundException("NO ID FOUND");
		}

	}

	public ResponseEntity<ResponseStructure<Product>> deleteProduct(int id) {

		Product product = dao.getProductById(id);
		if (product != null) {
			dao.deleteProduct(product);
			ResponseStructure<Product> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("DELETED SUCCESSFULLY");
			responseStructure.setData(product);
			return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.OK);
		} else {
			throw new NoIdFoundException("NO ID " + id + " FOUND");
		}
	}

	public ResponseEntity<ResponseStructure<Product>> getProductById(int id) {
		Product product = dao.getProductById(id);
		if (product != null) {
			ResponseStructure<Product> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData(product);
			return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.OK);
		} else {
			throw new NoIdFoundException("NO ID " + id + " FOUND");
		}
	}

	public ResponseEntity<ResponseStructure<List<Product>>> getAllProducts() {

		List<Product> products = dao.getAllProducts();

		ResponseStructure<List<Product>> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("SUCCESS");
		responseStructure.setData(products);
		return new ResponseEntity<ResponseStructure<List<Product>>>(responseStructure, HttpStatus.OK);
	}

}
