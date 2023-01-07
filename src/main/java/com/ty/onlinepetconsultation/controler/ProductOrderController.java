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

import com.ty.onlinepetconsultation.dto.ProductOrder;
import com.ty.onlinepetconsultation.dto.ResponseStructure;
import com.ty.onlinepetconsultation.service.ProductOrderService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/productorders")
public class ProductOrderController {

	@Autowired
	private ProductOrderService orderService;

	@ApiOperation(value = "Adding productOrders", notes = "input is productOrder object and output is productOrder object")
	@ApiResponses(value = { @ApiResponse(message = "SUCCESSFULLY CREATED", code = 201),
			@ApiResponse(message = "Productorder object not found", code = 404) })
	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<ProductOrder>> saveProductOrder(@RequestBody ProductOrder order) {
		return orderService.saveProductOrder(order);
	}

	@ApiOperation(value = "updating productOrders", notes = "input object is productOrder object and output is productOrder Object")
	@ApiResponses(value = { @ApiResponse(message = "productOrder object Not found ", code = 404) })
	@PutMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<ProductOrder>> updateProductOrder(@RequestBody ProductOrder order) {
		return orderService.updateProductOrder(order);
	}

	@ApiOperation(value = "get all productOrder details", notes = "output is fetching all the details of productOrder")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "no productOrder details found") })
	@GetMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<List<ProductOrder>>> getAllProductOrders() {
		return orderService.getAllProductOrders();
	}

	@ApiOperation(value = "get productOrder details by id", notes = "input is Integer value and output is productOrder Object")
	@ApiResponses(value = { @ApiResponse(message = "no product order found for the enterd id", code = 404) })
	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<ProductOrder>> getProductOrderById(@PathVariable int id) {
		return orderService.getProductOrderById(id);
	}

	@ApiOperation(value = "delete productOrder by id", notes = "input is Integer value and output is productOrder Object")
	@ApiResponses(value = { @ApiResponse(message = "no product order found for the enterd id", code = 404) })
	@DeleteMapping(value = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<ProductOrder>> deleteProductOrder(int id) {
		return orderService.deleteProductOrderById(id);
	}

}
