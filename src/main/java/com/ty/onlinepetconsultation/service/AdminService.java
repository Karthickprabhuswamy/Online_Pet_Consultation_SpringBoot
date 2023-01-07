package com.ty.onlinepetconsultation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.onlinepetconsultation.dao.AdminDao;
import com.ty.onlinepetconsultation.dto.Admin;
import com.ty.onlinepetconsultation.dto.ResponseStructure;
import com.ty.onlinepetconsultation.exception.InvalidCredentialsException;
import com.ty.onlinepetconsultation.exception.NoIdFoundException;
import com.ty.onlinepetconsultation.util.Encrypt;

@Service
public class AdminService {

	@Autowired
	private AdminDao adminDao;

	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin) {
		ResponseStructure<Admin> responseStructure = new ResponseStructure<>();
		admin = adminDao.saveAdmin(admin);
		if (admin!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("CREATED");
			responseStructure.setData(admin);
			return new ResponseEntity<ResponseStructure<Admin>>(responseStructure, HttpStatus.OK);
		} else {
			throw new InvalidCredentialsException("INVALID CREDENTIAL Detalies");
		}
		
	}

	public ResponseEntity<ResponseStructure<Admin>> findAdminById(int id) {
	              Admin admin=	adminDao.findAdminById(id);
		ResponseStructure<Admin> responseStructure = new ResponseStructure<>();
		if (admin != null) {

			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESSFULL");
			responseStructure.setData(adminDao.findAdminById(id));

			return new ResponseEntity<ResponseStructure<Admin>>(responseStructure, HttpStatus.OK);
		} else {
			throw new NoIdFoundException(id + "id is not found ");
		}

	}

	public ResponseEntity<ResponseStructure<Admin>> adminValidByEmail(String email, String password) {
		ResponseStructure<Admin> responseStructure = new ResponseStructure<>();

		Admin admin = adminDao.findAdminByEmail(email);
		if (admin != null) {
			if (admin.getPassword().equals(password)) {

				responseStructure.setStatus(HttpStatus.OK.value());
				responseStructure.setMessage("SUCCESSFULL");
				responseStructure.setData(admin);
				return new ResponseEntity<ResponseStructure<Admin>>(responseStructure, HttpStatus.OK);
			} else {
				throw new InvalidCredentialsException("INVALID CREDENTIAL");
			}

		} else {
			throw new NoIdFoundException(admin.getId() + "id is not found ");
		}

	}

	public ResponseEntity<ResponseStructure<Admin>> findAdminByPhone(long phone) {
		ResponseStructure<Admin> responseStructure = new ResponseStructure<>();

		if (adminDao.findAdminByPhone(phone) != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESSFULL");
			responseStructure.setData(adminDao.findAdminByPhone(phone));
			return new ResponseEntity<ResponseStructure<Admin>>(responseStructure, HttpStatus.OK);
		} else {
			throw new InvalidCredentialsException("INVALID PHONE NUMBER");
		}

	}

	public ResponseEntity<ResponseStructure<Admin>> findAdminByEmail(String email) {
		ResponseStructure<Admin> responseStructure = new ResponseStructure<>();

		if (adminDao.findAdminByEmail(email) != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESSFULL");
			responseStructure.setData(adminDao.findAdminByEmail(email));
			return new ResponseEntity<ResponseStructure<Admin>>(responseStructure, HttpStatus.OK);
		} else {
			throw new InvalidCredentialsException("INVALID PHONE NUMBER");
		}

	}


	public ResponseEntity<ResponseStructure<Admin>> deleteAdminById(int id) {
		ResponseStructure<Admin> responseStructure = new ResponseStructure<>();

		Admin admin = adminDao.findAdminById(id);
		if (adminDao.deleteAdmin(admin)) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESSFULL");
			responseStructure.setData(admin);

			return new ResponseEntity<ResponseStructure<Admin>>(responseStructure, HttpStatus.OK);

		} else {
			throw new NoIdFoundException(id + "id is not found ");
		}
	}

	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(Admin admin) {
		ResponseStructure<Admin> responseStructure = new ResponseStructure<>();

		if (adminDao.findAdminById(admin.getId()) != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESSFULL");
			responseStructure.setData(adminDao.saveAdmin(admin));

			return new ResponseEntity<ResponseStructure<Admin>>(responseStructure, HttpStatus.OK);

		} else {
			throw new NoIdFoundException("admin  is not found ");
		}

	}

	
	public ResponseEntity<ResponseStructure<Admin>> adminValidByphone(long phone, String password) {
		ResponseStructure<Admin> responseStructure = new ResponseStructure<>();

		Admin admin = adminDao.findAdminByPhone(phone);

		if (admin.getPassword().equals(password)) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESSFULL");
			responseStructure.setData(admin);

			return new ResponseEntity<ResponseStructure<Admin>>(responseStructure, HttpStatus.OK);

		} else {
			throw new InvalidCredentialsException("INVALID CREDENTIALS");
		}

	}

}
