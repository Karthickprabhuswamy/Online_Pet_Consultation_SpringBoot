package com.ty.onlinepetconsultation.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.onlinepetconsultation.dto.Admin;
import com.ty.onlinepetconsultation.repository.AdminRepository;

@Repository
public class AdminDao {

	@Autowired
	private AdminRepository repository;

	public Admin saveAdmin(Admin admin) {
		return repository.save(admin);
	}

	public Admin findAdminById(int id) {
		Optional<Admin> optional = repository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	public Admin findAdminByEmail(String email) {
		Optional<Admin> optional = repository.findByEmail(email);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	public Admin findAdminByPhone(long phone) {
		Optional<Admin> optional = repository.findByPhone(phone);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	public boolean deleteAdmin(Admin admin) {
		repository.delete(admin);
		return true;
	}

}
