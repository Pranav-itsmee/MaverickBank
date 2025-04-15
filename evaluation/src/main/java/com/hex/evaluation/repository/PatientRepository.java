package com.hex.evaluation.repository;

import com.hex.evaluation.model.Patient;
import com.hex.evaluation.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    
    List<Patient> findByDoctors(Doctor doctor);
}
