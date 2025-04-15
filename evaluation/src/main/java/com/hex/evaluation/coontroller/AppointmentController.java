package com.hex.evaluation.coontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hex.evaluation.exception.InvalidIDException;
import com.hex.evaluation.service.AppointmentService;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
	
	@Autowired
	private AppointmentService appointmentService;

	@PostMapping("/add/{patientId}/{doctorId}")
	public String add(@PathVariable int patientId
			, @PathVariable int doctorId) throws InvalidIDException {
		return appointmentService.add(patientId, doctorId);
	}
	
	
}
