package com.ty.onlinepetconsultation.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.onlinepetconsultation.dao.UserDao;
import com.ty.onlinepetconsultation.dto.ResponseStructure;
import com.ty.onlinepetconsultation.dto.User;
import com.ty.onlinepetconsultation.exception.InvalidCredentialsException;
import com.ty.onlinepetconsultation.exception.NoIdFoundException;


@Service
public class UserService {

	@Autowired
	public UserDao userDao;

	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Created");
		responseStructure.setData(userDao.saveUser(user));

		return new ResponseEntity<>(responseStructure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<User>> findUserById(int id) {
		User user = userDao.getUserById(id);
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		if (user != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(user);
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			throw new NoIdFoundException("Id not found: " + id);
		}
	}

	public ResponseEntity<ResponseStructure<User>> validationByEmail(String email, String password) {
		User user = userDao.findUserByEmail(email);
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		if (user != null) {
			if (user.getPassword().equals(password)) {

				responseStructure.setStatus(HttpStatus.OK.value());
				responseStructure.setMessage("success");
				responseStructure.setData(user);
				return new ResponseEntity<>(responseStructure, HttpStatus.OK);
			} else {

				throw new InvalidCredentialsException("Invalid  Credentials");
			}

		} else {
			throw new NoIdFoundException(user.getId() + "Id not found");

		}

	}

	public ResponseEntity<ResponseStructure<User>> validationByPhone(long phone, String password) {
		User user = userDao.findUserByPhone(phone);
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		if (user != null) {
			if (user.getPassword().equals(password)) {

				responseStructure.setStatus(HttpStatus.OK.value());
				responseStructure.setMessage("success");
				responseStructure.setData(user);
				return new ResponseEntity<>(responseStructure, HttpStatus.OK);
				
			} else {

				throw new InvalidCredentialsException("Invalid  Credentials");
			}

		} else {
			throw new NoIdFoundException(user.getPhone() + "PhoneNumber not found");

		}

	}

	public ResponseEntity<ResponseStructure<User>> findUserByEmail(String email) {
		User user = userDao.findUserByEmail(email);
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		if (user != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(userDao.findUserByEmail(email));
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {

			throw new NoIdFoundException("Invalid Email: " + email);
		}

	}

	public ResponseEntity<ResponseStructure<User>> findUserByPhone(long phone) {
		User user = userDao.findUserByPhone(phone);
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		if (user != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(userDao.findUserByPhone(phone));
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			throw new NoIdFoundException("Please enter valid Phone_number " + phone);
		}
	}

	public ResponseEntity<ResponseStructure<List<User>>> findAllUser() {
		List<User> user = userDao.getAllUser();
		ResponseStructure<List<User>> responseStructure = new ResponseStructure<>();
		if (user != null) {

			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(user);
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			throw new NoIdFoundException("User not Found");
		}

	}

	public ResponseEntity<ResponseStructure<User>> deleteUserById(int id) {
		User user = userDao.getUserById(id);

		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		if (userDao.deleteUser(user)) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(user);
		}
		throw new NoIdFoundException("Id not found:" + id);
	}

	public ResponseEntity<ResponseStructure<User>> updateUser(User user) {

		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		User user2 = userDao.getUserById(user.getId());
		if(user2!=null) {
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Updated");
		responseStructure.setData(userDao.saveUser(user2));
		return new ResponseEntity<>(responseStructure, HttpStatus.CREATED);
		}else {

			throw new InvalidCredentialsException("Invalid Credential");
		}
	}

}
