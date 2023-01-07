package com.ty.onlinepetconsultation.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.onlinepetconsultation.dto.Admin;
import com.ty.onlinepetconsultation.dto.ResponseStructure;
import com.ty.onlinepetconsultation.service.AdminService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Validated
@RequestMapping("/admins")
public class AdminControler {

	@Autowired
	private AdminService adminService;

	@ApiOperation(value = "save admin", notes = "Takes input as Admin object and returns Admin object with id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully Registered") })
	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(@RequestBody Admin admin) {
		return adminService.saveAdmin(admin);
	}

	@ApiOperation(value = "find admin by id", notes = "Takes input as id and return admin object ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfuly registered") ,@ApiResponse(code = 404, message = "Not Found")})
	@GetMapping(value = "/id/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Admin>> findAdminById(@PathVariable int id) {
		return adminService.findAdminById(id);
	}

	@ApiOperation(value = "email validetion", notes = "Takes input as email and password  and returns Admin object ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully Registered") ,
			@ApiResponse(code = 404, message = "Not Found")})
	@GetMapping(value = "/email/{email} ",  produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<ResponseStructure<Admin>> adminValidByEmail(@PathVariable String email,
			@RequestParam String password) {
		return adminService.adminValidByEmail(email, password);
	}

	@ApiOperation(value = "find admin by id", notes = "Takes input as phone and returns Admin object with phone")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully Registered"),@ApiResponse(code = 404, message = "Not Found") })
	@GetMapping(value = "/phone",  produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })

	public ResponseEntity<ResponseStructure<Admin>> findAdminByPhone(@RequestParam long phone) {
		return adminService.findAdminByPhone(phone);
	}

	@ApiOperation(value = "find admin by email", notes = "Takes input as email and returns Admin object with email")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully Registered"),@ApiResponse(code = 404, message = "Not Found") })
	@GetMapping(value = "/{email}", produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<ResponseStructure<Admin>> findAdminByEmail(@PathVariable String email) {
		return adminService.findAdminByEmail(email);
	}

	@ApiOperation(value = "delete admin", notes = "Takes input as id  and  delete Admin object with ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully Registered") ,@ApiResponse(code = 404, message = "Not Found")})
	@DeleteMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<ResponseStructure<Admin>> deleteAdminById(@PathVariable int id) {
		return adminService.deleteAdminById(id);
	}
	
	
	@ApiOperation(value = "update admin", notes = "Takes input as Admin object and update Admin object with id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully Registered") ,@ApiResponse(code = 404, message = "Not Found")})
	@PutMapping( consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(@RequestBody Admin admin){
		return adminService.updateAdmin(admin);
	}
	
	@ApiOperation(value = "update admin", notes = "Takes input as phone and password and returns Admin object with ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully Registered" ),@ApiResponse(code = 404, message = "Not Found") })
	@GetMapping(value = "/phone/{phone}", produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	
	public ResponseEntity<ResponseStructure<Admin>> adminValidByphone(@PathVariable long phone, @RequestParam String password) {
		  return adminService.adminValidByphone(phone, password);
	}

}
