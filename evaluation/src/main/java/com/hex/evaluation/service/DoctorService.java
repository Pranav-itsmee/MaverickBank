package com.hex.evaluation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hex.evaluation.exception.InvalidIDException;
import com.hex.evaluation.model.*;
import com.hex.evaluation.repository.DoctorRepository;
import com.hex.evaluation.repository.PatientRepository;

@Service
public class DoctorService {
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private PatientRepository patientRepository;
	
	public Doctor add(Doctor doctor) {
		return doctorRepository.save(doctor);
	}
	
	public List<Patient> getAllPatientByDoctorId(int doctorId) throws InvalidIDException{
		Optional<Doctor> doctor = doctorRepository.findById(doctorId);
		if(doctor.isEmpty())
			throw new InvalidIDException("Doctor Not Found");
		return patientRepository.findByDoctors(doctor.get());
	}
}
