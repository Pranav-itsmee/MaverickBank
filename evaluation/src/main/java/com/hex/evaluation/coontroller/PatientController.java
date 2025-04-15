package com.hex.evaluation.coontroller;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hex.evaluation.model.Patient;

import com.hex.evaluation.service.PatientService;

@RestController
@RequestMapping("/api/patient")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@PostMapping("/add")
	public String add(@RequestBody Patient patient){
		return patientService.add(patient);
	}
	
	
}
