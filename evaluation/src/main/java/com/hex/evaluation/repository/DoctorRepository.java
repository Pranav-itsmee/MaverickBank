package com.hex.evaluation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hex.evaluation.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer>{

	List<Doctor> findBydoctorId(int doctorId);

}
