package com.ty.onlinepetconsultation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.onlinepetconsultation.dao.ProductDao;
import com.ty.onlinepetconsultation.dao.ProductOrderDao;
import com.ty.onlinepetconsultation.dto.Product;
import com.ty.onlinepetconsultation.dto.ProductOrder;
import com.ty.onlinepetconsultation.dto.ResponseStructure;
import com.ty.onlinepetconsultation.exception.NoIdFoundException;

@Service
public class ProductOrderService {

	@Autowired
	private ProductOrderDao dao;
	
	@Autowired
	private ProductDao dao2;

	public ResponseEntity<ResponseStructure<ProductOrder>> saveProductOrder(ProductOrder order) {

		List<Product> products = order.getProducts();
		double totalCost = 0;
		ProductOrder order1=null;
		int count = 0;
		if (products != null) {
			for (Product product : products) {
				count++;
				totalCost = totalCost + product.getCost();
				product.setOrder(order);
			}
			order.setTotalCost(totalCost);
			order.setStatus("DELIVERING " + count + " PRODUCTS");
			order1=dao.saveProductOrder(order);
			for(Product product : products) {
				product.setOrder(order1);
				dao2.saveProduct(product);
			}
		}

		ResponseStructure<ProductOrder> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("SUCCESS");
		responseStructure.setData(order1);
		return new ResponseEntity<ResponseStructure<ProductOrder>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<ProductOrder>> updateProductOrder(ProductOrder order) {
		ProductOrder order2 = dao.getProductOrderById(order.getId());
		if (order2 != null) {
			ResponseStructure<ProductOrder> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData(dao.saveProductOrder(order2));
			return new ResponseEntity<ResponseStructure<ProductOrder>>(responseStructure, HttpStatus.CREATED);
		} else {
			throw new NoIdFoundException("NO PRODUCT ORDER FOUND FOR ID " + order.getId());
		}
	}

	public ResponseEntity<ResponseStructure<ProductOrder>> deleteProductOrderById(int id) {
		ProductOrder order = dao.getProductOrderById(id);
		if (order != null) {
			dao.deleteProductOrder(order);
			ResponseStructure<ProductOrder> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("DELETED SUCCESSFULLY");
			responseStructure.setData(order);
			return new ResponseEntity<ResponseStructure<ProductOrder>>(responseStructure, HttpStatus.OK);
		} else {
			throw new NoIdFoundException("NO PRODUCT ORDER FOUND FOR ID " + id + " TO DELETE");
		}
	}

	public ResponseEntity<ResponseStructure<List<ProductOrder>>> getAllProductOrders() {
		List<ProductOrder> orders = dao.getAllProductOrder();
		ResponseStructure<List<ProductOrder>> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("SUCCESS");
		
			responseStructure.setData(orders);
		
		return new ResponseEntity<ResponseStructure<List<ProductOrder>>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<ProductOrder>> getProductOrderById(int id) {
		ProductOrder order = dao.getProductOrderById(id);
		if (order != null) {
			ResponseStructure<ProductOrder> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData(order);
			return new ResponseEntity<ResponseStructure<ProductOrder>>(responseStructure, HttpStatus.OK);
		} else {
			throw new NoIdFoundException("NO ID " + id + " FOUND ");
		}
	}

}
