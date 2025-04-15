package com.hex.evaluation.coontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hex.evaluation.exception.InvalidIDException;
import com.hex.evaluation.model.Doctor;
import com.hex.evaluation.model.Patient;
import com.hex.evaluation.service.DoctorService;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	@PostMapping("/add")
	public Doctor CreateDoctor(@RequestBody Doctor doctor){
		return doctorService.add(doctor);
	}	

	@GetMapping("/getAllPatientbyDocId/{doctorId}")
	public List<Patient> getAllPatientByDocId(@PathVariable int doctorId) throws InvalidIDException {
		return doctorService.getAllPatientByDoctorId(doctorId);
	}
}