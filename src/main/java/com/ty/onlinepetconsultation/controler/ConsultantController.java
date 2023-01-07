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
import org.springframework.web.bind.annotation.RestController;

import com.ty.onlinepetconsultation.dto.Consultant;
import com.ty.onlinepetconsultation.dto.ResponseStructure;
import com.ty.onlinepetconsultation.service.ConsutantService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Validated
@RequestMapping("/consutants")
public class ConsultantController {

	
	@Autowired
	ConsutantService consutantService;

	@ApiOperation(value = "Register Consultant", notes = "Taking consultant object and Returning the consultant with id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Sucessfully Registerd") })
	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<ResponseStructure<Consultant>> saveConsultant(@RequestBody Consultant consultant) {

		return consutantService.saveConsultant(consultant);

	}

	@ApiOperation(value = "Find Consultant by Id", notes = "Taking consultant id and Returning the consultant object with id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Found sucessfully"),
			@ApiResponse(code = 404, message = "Not Found") })
	@GetMapping(value = "/id/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<ResponseStructure<Consultant>> getConsultantById(@PathVariable int id) {

		return consutantService.getConsultantById(id);

	}

	@ApiOperation(value = "Find Consultant by Name", notes = "Taking consultant name  and Returning the consultant object  with id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Found sucessfully"),
			@ApiResponse(code = 404, message = "Not Found") })
	@GetMapping(value = "/name/{name}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<ResponseStructure<Consultant>> getConsultantByName(@PathVariable String name) {

		return consutantService.getConsultantByName(name);

	}

	@ApiOperation(value = "Find Consultant by Email", notes = "Taking consultant email  and Returning the consultant object  with id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Found sucessfully"),
			@ApiResponse(code = 404, message = "Not Found") })
	@GetMapping(value = "/email/{email}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<ResponseStructure<Consultant>> getConsultantByEmail(@PathVariable String email) {

		return consutantService.getConsultantByEmail(email);

	}

	@ApiOperation(value = "Get All Consultant", notes = "Returning the consultant object with id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Sucessfully Registerd") })
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<ResponseStructure<List<Consultant>>> getALlConsultants() {

		return consutantService.getAllConsultant();

	}

	@ApiOperation(value = "Delete Consultant", notes = "Taking consultant object and retning the String message")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Found sucessfully"),
			@ApiResponse(code = 404, message = "Not Found") })
	@DeleteMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<ResponseStructure<Consultant>> deleteConsultant(@PathVariable int id) {

		return consutantService.deleteConsulantById(id);

	}

	@ApiOperation(value = "Update the  Consultant", notes = "Taking consultant object and retning the updated  consultant object  with id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Found sucessfully"),
			@ApiResponse(code = 404, message = "Not Found") })
	@PutMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<ResponseStructure<Consultant>> updateConsultant(@RequestBody Consultant consultant) {

		return consutantService.updateConsultant(consultant);

	}

}
