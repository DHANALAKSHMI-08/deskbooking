package com.example.desk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.desk.model.UserRegister;



public interface UserRepository extends JpaRepository<UserRegister, Long>{

		UserRegister findByUsername(String username);
		

	}



