package com.ty.onlinepetconsultation.controler;

import java.util.List;

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

import com.ty.onlinepetconsultation.dto.ResponseStructure;
import com.ty.onlinepetconsultation.dto.User;
import com.ty.onlinepetconsultation.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.val;

@RestController
@Validated
@RequestMapping("/users")
public class UserControler {

	@Autowired
	private UserService userService;

	@ApiOperation(value = "save user", notes = "input is user obj and return same obj with id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully saved") })
	@PostMapping(value = "/save",consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user) {
		return userService.saveUser(user);

	}

	@ApiOperation(value = "Get user by id", notes = "input is user obj and return same obj with id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully registered"), 
			@ApiResponse(code = 404, message = "Not Found")})
	@GetMapping(value = "/{id}",  produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<User>> getUserById(@PathVariable int id) {
		return userService.findUserById(id);
	}

	@ApiOperation(value = "get user by email", notes = "input is user obj and return same obj with email")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully registered") })
	@GetMapping(value = "/email",  produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<User>> getUserByEmail(@RequestParam String email) {
		return userService.findUserByEmail(email);
	}

	@ApiOperation(value = "validate user by email", notes = "input is user obj and return same obj with email")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully registered"),
			@ApiResponse(code = 404, message = "Not Found") })
	@GetMapping(value = "/{email}/email", produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<User>> validateUserByEmail(@PathVariable String email,
			@RequestParam String password) {
		return userService.validationByEmail(email, password);
	}

	@ApiOperation(value = "validate user by phone", notes = "input is user obj and return same obj with phone")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully registered"),
			@ApiResponse(code = 404, message = "Not Found")})
	@GetMapping( value="/phone/{password}",  produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<User>> validateUserByPhone(@RequestParam long phone,@PathVariable String password) {
		return userService.validationByPhone(phone,password);
	}

	@ApiOperation(value = "Get user by phone number", notes = "input is user obj and return same obj with phone ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully registered"),
			@ApiResponse(code = 404, message = "Not Found")})
	@GetMapping(value = "/phone/{phone}" , produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<User>> findUserByPhone(@RequestParam long phone) {
		return userService.findUserByPhone(phone);
	}

	@ApiOperation(value = "Get All user", notes = "input is user obj and return with id ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully registered") })
	@GetMapping(produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<List<User>>> getAllUser() {
		return userService.findAllUser();
	}

	@ApiOperation(value = "delete customers by id", notes = "input is user obj and return same obj with id ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully registered"),
			@ApiResponse(code = 404, message = "Not Found")})
	@DeleteMapping(value = "/delete/{id}",  produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<User>> deleteUserById(@RequestParam int id) {
		return userService.deleteUserById(id);
	}
	
	@ApiOperation(value = "update user", notes = "input is user obj and return same obj with id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully saved"),
			@ApiResponse(code = 404, message = "Not Found")})
	@PutMapping( consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User user) {
		return userService.updateUser(user);

	}

}
