package com.ty.onlinepetconsultation.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.onlinepetconsultation.dto.Booking;
import com.ty.onlinepetconsultation.dto.User;
import com.ty.onlinepetconsultation.repository.BookingRepository;

@Repository
public class BookingDao {

	@Autowired
	BookingRepository bookingRepository;

	public Booking registerBooking(Booking booking) {

		return bookingRepository.save(booking);
	}

	public List<Booking> getBookingByUser(User user) {

		return bookingRepository.findByUser(user);
	}

	public Booking getBookingById(int id) {

		Optional<Booking> optional = bookingRepository.findById(id);

		if (optional.isPresent()) {

			return optional.get();
		} else {
			return null;
		}
	}

	public boolean cancleBooking(Booking booking) {
		
		bookingRepository.delete(booking);
		
		return true;	
	}

}
