package com.hex.evaluation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hex.evaluation.model.Patient;
import com.hex.evaluation.repository.PatientRepository;

@Service
public class PatientService {
	
	@Autowired
	private PatientRepository patientRepository;
	
	public String add(Patient patient) {
		patientRepository.save(patient);
		return "Added successfully";
	}
}