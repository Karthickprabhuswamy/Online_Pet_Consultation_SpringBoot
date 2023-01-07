package com.ty.onlinepetconsultation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.onlinepetconsultation.dao.ConsultantDao;
import com.ty.onlinepetconsultation.dto.Consultant;
import com.ty.onlinepetconsultation.dto.ResponseStructure;
import com.ty.onlinepetconsultation.exception.InvalidCredentialsException;
import com.ty.onlinepetconsultation.exception.NoIdFoundException;

@Service
public class ConsutantService {

	@Autowired
	ConsultantDao consultantDao;

	public ResponseEntity<ResponseStructure<Consultant>> saveConsultant(Consultant consultant) {

		ResponseStructure<Consultant> responseStructure = new ResponseStructure<Consultant>();

		Consultant consultant2 = consultantDao.saveConsultant(consultant);

		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("SUCCESSFULLY CREATED");
		responseStructure.setData(consultant2);
		return new ResponseEntity<ResponseStructure<Consultant>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<List<Consultant>>> getAllConsultant() {

		ResponseStructure<List<Consultant>> responseStructure = new ResponseStructure<List<Consultant>>();

		responseStructure.setStatus(HttpStatus.OK.value());

		responseStructure.setMessage("Sucess");

		responseStructure.setData(consultantDao.getAllConsultants());

		return new ResponseEntity<ResponseStructure<List<Consultant>>>(responseStructure, HttpStatus.OK);

	}

	public ResponseEntity<ResponseStructure<Consultant>> getConsultantById(int id) {

		ResponseEntity<ResponseStructure<Consultant>> responseEntity;

		Consultant consultant = consultantDao.findConsultantById(id);

		ResponseStructure<Consultant> responseStructure = new ResponseStructure<Consultant>();

		if (consultant != null) {

			responseStructure.setStatus(HttpStatus.OK.value());

			responseStructure.setMessage("Sucess");

			responseStructure.setData(consultant);

			return new ResponseEntity<ResponseStructure<Consultant>>(responseStructure, HttpStatus.OK);
		} else {

			throw new NoIdFoundException("Id" + id + ",Not Found");
		}

	}

	public ResponseEntity<ResponseStructure<Consultant>> getConsultantByNumber(long phone) {

		ResponseEntity<ResponseStructure<Consultant>> responseEntity;

		Consultant consultant = consultantDao.findConsultantByPhone(phone);

		ResponseStructure<Consultant> responseStructure = new ResponseStructure<Consultant>();

		if (consultant != null) {

			responseStructure.setStatus(HttpStatus.OK.value());

			responseStructure.setMessage("Sucess");

			responseStructure.setData(consultant);

			return new ResponseEntity<ResponseStructure<Consultant>>(responseStructure, HttpStatus.OK);
		} else {

			throw new InvalidCredentialsException("Please Enter proper Phone Number");
		}

	}

	public ResponseEntity<ResponseStructure<Consultant>> getConsultantByName(String name) {

		ResponseEntity<ResponseStructure<Consultant>> responseEntity;

		Consultant consultant = consultantDao.findConsultantByName(name);

		ResponseStructure<Consultant> responseStructure = new ResponseStructure<Consultant>();

		if (consultant != null) {

			responseStructure.setStatus(HttpStatus.OK.value());

			responseStructure.setMessage("Sucess");

			responseStructure.setData(consultant);

			return new ResponseEntity<ResponseStructure<Consultant>>(responseStructure, HttpStatus.OK);
		} else {

			throw new InvalidCredentialsException("Please Enter proper name");
		}

	}

	public ResponseEntity<ResponseStructure<Consultant>> getConsultantByEmail(String email) {

		ResponseEntity<ResponseStructure<Consultant>> responseEntity;

		Consultant consultant = consultantDao.findConsultantByEmail(email);

		ResponseStructure<Consultant> responseStructure = new ResponseStructure<Consultant>();

		if (consultant != null) {

			responseStructure.setStatus(HttpStatus.OK.value());

			responseStructure.setMessage("Sucess");

			responseStructure.setData(consultant);

			return new ResponseEntity<ResponseStructure<Consultant>>(responseStructure, HttpStatus.OK);
		} else {

			throw new InvalidCredentialsException("Please Enter proper email");
		}

	}

	public ResponseEntity<ResponseStructure<Consultant>> deleteConsulantById(int id) {

		ResponseStructure<Consultant> responseStructure = new ResponseStructure<Consultant>();
		
		Consultant consultant = consultantDao.findConsultantById(id);

		if (consultantDao.deleteConsutant(consultant)) {

			responseStructure.setStatus(HttpStatus.OK.value());

			responseStructure.setMessage("Sucess");

			responseStructure.setData(consultant);

			return new ResponseEntity<ResponseStructure<Consultant>>(responseStructure, HttpStatus.OK);

		} else {
			throw new NoIdFoundException("No Id FOund");

		}

	}

	public ResponseEntity<ResponseStructure<Consultant>> updateConsultant(Consultant consultant) {

		ResponseStructure<Consultant> responseStructure = new ResponseStructure<Consultant>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("SUCCESSFULLY CREATED");
		responseStructure.setData(consultantDao.saveConsultant(consultant));
		return new ResponseEntity<ResponseStructure<Consultant>>(responseStructure, HttpStatus.CREATED);
	}

}
