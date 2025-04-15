package com.hex.evaluation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hex.evaluation.exception.InvalidIDException;
import com.hex.evaluation.model.Doctor;
import com.hex.evaluation.model.Patient;
import com.hex.evaluation.repository.DoctorRepository;
import com.hex.evaluation.repository.PatientRepository;

@Service
public class AppointmentService {
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	public String add(int patientId, int doctorId) throws InvalidIDException {
		Optional<Patient> patient = patientRepository.findById(patientId);
		List<Doctor> doctor = doctorRepository.findBydoctorId(doctorId);
		
		if(patient.isEmpty() && doctor.isEmpty())
			throw new InvalidIDException("Invalid Patient or doctor Id");
		
		patient.get().setDoctors(doctor);
        patientRepository.save(patient.get());
        
        return "Appointment added";
	}
}
