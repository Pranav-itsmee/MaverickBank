package com.hex.evaluation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hex.evaluation.model.User;

public interface AuthRepository extends JpaRepository<User, Integer>{
	User findByUsername(String username);
}
