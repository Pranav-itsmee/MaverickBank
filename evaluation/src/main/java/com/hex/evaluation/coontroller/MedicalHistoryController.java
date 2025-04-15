package com.hex.evaluation.coontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hex.evaluation.model.MedicalHistory;
import com.hex.evaluation.service.MedicalHistoryService;
@RestController
@RequestMapping("/api/medical_history")
public class MedicalHistoryController {

	
	@Autowired
	private MedicalHistoryService medicalHistoryService;
	
	@PostMapping("/add")
	public String add(@RequestBody MedicalHistory medicalHistory){
		return medicalHistoryService.add(medicalHistory);
	}
}
