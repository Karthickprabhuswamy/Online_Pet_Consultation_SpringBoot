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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.onlinepetconsultation.dto.Booking;
import com.ty.onlinepetconsultation.dto.ResponseStructure;
import com.ty.onlinepetconsultation.dto.User;
import com.ty.onlinepetconsultation.service.BookingService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Validated
@RestController
@RequestMapping("/bookings")
public class BookingController {

	@Autowired
	BookingService bookingService;
	@ApiOperation(value = "Register a Appointment", notes = "Takeing input as Booking object and returning as Appointmnet with id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Appointmnet Confirmed") })
	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Booking>> getAppointment(@RequestBody Booking booking) {

		return bookingService.getAppointment(booking);

	}

	@ApiOperation(value = "Get Appointment By Id", notes = "Takeing input as Booking id and returning as Appointmnet object")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Appointmnet found sucessful"),
			@ApiResponse(code = 404, message = "Appointmnet not Found") })
	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Booking>> getAppointmentById(@PathVariable int id) {
		return bookingService.getAppointmentById(id);

	}

	@ApiOperation(value = "Get All Appointments", notes = "Takeing input as user and returning all the  Appointmnet objects")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Appointmnet found sucessful") })
	@GetMapping(value ="/getBookng", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<List<Booking>>> getAllAppointmentByUser(@RequestBody User user) {

		return bookingService.getAllBookingsByUser(user);

	}

	@ApiOperation(value = "Cancle Appointment By Id", notes = "Takeing input as Booking id and returning a string meassage as a output")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Appointmnt canclled sucessful"),
			@ApiResponse(code = 404, message = "Appointmnet not Found") })
	@DeleteMapping(value = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<String>> deleteAppointmentById(@PathVariable int id) {

		return bookingService.CancelAppointment(id);

	}
}