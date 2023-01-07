package com.ty.onlinepetconsultation.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.onlinepetconsultation.dto.User;
import com.ty.onlinepetconsultation.repository.UserRepository;

@Repository
public class UserDao {
	@Autowired
	private UserRepository userRepository;

	public User saveUser(User user) {
		return userRepository.save(user);

	}

	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	public User getUserById(int id) {
		Optional<User> optional = userRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	public User findUserByEmail(String email) {
		Optional<User> user = userRepository.findByEmail(email);
		if (user.isPresent()) {
			return user.get();
		} else {
			return null;
		}

	}

	public User findUserByPhone(long phone) {
		Optional<User> user = userRepository.findByPhone(phone);
		if (user.isPresent()) {
			return user.get();
		} else {
			return null;
		}
	}

	public boolean deleteUser(User user) {

		userRepository.delete(user);
		return true;

	}

	
}
