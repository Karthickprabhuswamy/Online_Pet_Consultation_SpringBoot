package com.ty.onlinepetconsultation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.onlinepetconsultation.dto.Booking;
import com.ty.onlinepetconsultation.dto.User;

public interface BookingRepository extends JpaRepository<Booking, Integer>{
	
	List<Booking> findByUser(User user);

}
