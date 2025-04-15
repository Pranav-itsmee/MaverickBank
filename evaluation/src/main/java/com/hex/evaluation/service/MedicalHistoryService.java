package com.hex.evaluation.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.hex.evaluation.model.MedicalHistory;
import com.hex.evaluation.repository.MedicalHistoryRepository;

public class MedicalHistoryService {

	
	@Autowired
	private MedicalHistoryRepository medicalHistoryRepository;
	
	public String add(MedicalHistory medicalHistory) {
		medicalHistoryRepository.save(medicalHistory);
		return "Added successfully";
	}
}
