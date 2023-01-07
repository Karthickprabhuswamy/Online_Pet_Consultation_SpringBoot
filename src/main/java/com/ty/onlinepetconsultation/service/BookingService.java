package com.ty.onlinepetconsultation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.onlinepetconsultation.dao.BookingDao;
import com.ty.onlinepetconsultation.dto.Booking;
import com.ty.onlinepetconsultation.dto.Consultant;
import com.ty.onlinepetconsultation.dto.ResponseStructure;
import com.ty.onlinepetconsultation.dto.User;
import com.ty.onlinepetconsultation.exception.NoIdFoundException;

@Service
public class BookingService {

	@Autowired
	BookingDao bookingDao;

	public ResponseEntity<ResponseStructure<Booking>> getAppointment(Booking booking) {

		ResponseStructure<Booking> responseStructure = new ResponseStructure<Booking>();

		Consultant consultant = booking.getConsultants();

		if (consultant == null) {

			consultant.setStatus("No Veterinary-Doctors Available");

		}

		Booking booking2 = bookingDao.registerBooking(booking);

		responseStructure.setStatus(HttpStatus.CREATED.value());

		responseStructure.setMessage("Sucessful");

		responseStructure.setData(booking2);

		return new ResponseEntity<ResponseStructure<Booking>>(responseStructure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<Booking>> getAppointmentById(int id) {

		Booking booking = bookingDao.getBookingById(id);

		ResponseStructure<Booking> responseStructure = new ResponseStructure<Booking>();

		if (booking != null) {

			responseStructure.setStatus(HttpStatus.OK.value());

			responseStructure.setMessage("Sucessful");

			responseStructure.setData(booking);

			return new ResponseEntity<ResponseStructure<Booking>>(responseStructure, HttpStatus.OK);

		} else {

			throw new NoIdFoundException("Given Id not Found");
		}

	}

	public ResponseEntity<ResponseStructure<String>> CancelAppointment(int id) {

		ResponseStructure<String> responseStructure = new ResponseStructure<>();

		Booking booking = bookingDao.getBookingById(id);

		if (booking != null) {
			Consultant consultant = booking.getConsultants();
		}
		if (bookingDao.cancleBooking(booking)) {

			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("successful");
			responseStructure.setData("Booking cancelled successfully");

			return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.OK);
		} else {
			throw new NoIdFoundException("Given booking id not found");
		}
	}

	public ResponseEntity<ResponseStructure<List<Booking>>> getAllBookingsByUser(User user) {

		List<Booking> bookings = bookingDao.getBookingByUser(user);
		ResponseStructure<List<Booking>> rs = new ResponseStructure<>();

		rs.setStatus(HttpStatus.OK.value());
		rs.setMessage("successful");
		rs.setData(bookings);

		return new ResponseEntity<ResponseStructure<List<Booking>>>(rs, HttpStatus.OK);

	}

}
