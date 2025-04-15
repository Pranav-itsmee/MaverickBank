package com.hex.evaluation.coontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.hex.evaluation.model.MedicalHistory;
import com.hex.evaluation.service.MedicalHistoryService;

public class MedicalHistoryController {

	
	@Autowired
	private MedicalHistoryService medicalHistoryService;
	
	@PostMapping("/add")
	public String add(@RequestBody MedicalHistory medicalHistory){
		return medicalHistoryService.add(medicalHistory);
	}
}
