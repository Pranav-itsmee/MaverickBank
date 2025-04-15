package com.hex.evaluation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hex.evaluation.model.MedicalHistory;
import com.hex.evaluation.repository.MedicalHistoryRepository;
@Service
public class MedicalHistoryService {

	
	@Autowired
	private MedicalHistoryRepository medicalHistoryRepository;
	
	public String add(MedicalHistory medicalHistory) {
		medicalHistoryRepository.save(medicalHistory);
		return "Added successfully";
	}
}
