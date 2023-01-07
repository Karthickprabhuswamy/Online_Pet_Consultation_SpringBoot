package com.ty.onlinepetconsultation.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.onlinepetconsultation.dto.Consultant;
import com.ty.onlinepetconsultation.repository.ConsultantRepository;

@Repository
public class ConsultantDao {

	@Autowired
	ConsultantRepository consultantRepository;

	public Consultant saveConsultant(Consultant consultant) {

		return consultantRepository.save(consultant);
	}

	public Consultant findConsultantByEmail(String email) {

		Optional<Consultant> optional = consultantRepository.findByEmail(email);

		if (optional.isPresent()) {

			return optional.get();
		} else {

			return null;

		}
	}

	public Consultant findConsultantByPhone(long phone) {

		Optional<Consultant> optional = consultantRepository.findByPhone(phone);

		if (optional.isPresent()) {

			return optional.get();
		} else {

			return null;

		}
	}

	public Consultant findConsultantById(int id) {

		Optional<Consultant> optional = consultantRepository.findById(id);

		if (optional.isPresent()) {

			return optional.get();
		} else {

			return null;

		}
	}																	

	public List<Consultant> getAllConsultants() {

		return consultantRepository.findAll();
	}

	public Consultant findConsultantByName(String name) {

		Optional<Consultant> optional = consultantRepository.findByName(name);

		if (optional.isPresent()) {

			return optional.get();
		} else {

			return null;

		}

	}

	public boolean deleteConsutant(Consultant consultant) {
		
		consultantRepository.delete(consultant);

			return true;

		}
	

	}

