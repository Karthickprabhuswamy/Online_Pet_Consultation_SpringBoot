package com.ty.onlinepetconsultation.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.onlinepetconsultation.dto.Product;
import com.ty.onlinepetconsultation.dto.ResponseStructure;
import com.ty.onlinepetconsultation.service.ProductService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

	@Autowired
	private ProductService service;
	

	@ApiOperation(value = "add products", notes = "input is product object and output is product object")
	@ApiResponses(value = { @ApiResponse(message = "successfully created product object", code = 201),
			@ApiResponse(message = "no product details found", code = 404) })
	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody Product product) {
		return service.saveProducts(product);
	}

	@ApiOperation(value = "updating product", notes = "input object is product object and output is product Object")
	@ApiResponses(value = { @ApiResponse(message = "product object Not found ", code = 404) })
	@PutMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Product>> updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	}
  
	@ApiOperation(value = "get all product details", notes = "output is fetching all the details of product")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "no product details found") })
	@GetMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<List<Product>>> getAllProducts() {
		return service.getAllProducts();
	}

	@ApiOperation(value = "get product details by id", notes = "input is Integer value and output is product Object")
	@ApiResponses(value = { @ApiResponse(message = "no product found for the enterd id", code = 404) })
	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Product>> getProductById(@PathVariable int id) {
		return service.getProductById(id);
	}

	@ApiOperation(value = "delete product by id", notes = "input is Integer value and output is product Object")
	@ApiResponses(value = { @ApiResponse(message = "no product found for the enterd id", code = 404) })
	@DeleteMapping(value = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Product>> deleteProduct(@PathVariable int id) {
		return service.deleteProduct(id);
	}

}
