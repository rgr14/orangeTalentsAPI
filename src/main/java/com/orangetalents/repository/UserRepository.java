package com.orangetalents.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orangetalents.model.User;


public interface UserRepository  extends JpaRepository<User, Long>{
	
	
}
