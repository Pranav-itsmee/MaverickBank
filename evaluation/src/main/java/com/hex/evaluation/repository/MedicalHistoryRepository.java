package com.hex.evaluation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hex.evaluation.model.MedicalHistory;

public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory, Integer> {

}
