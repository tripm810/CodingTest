package com.coding.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coding.test.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	
		public  List<User> findByEmail(String email);
		
		public  List<User> findByMobileNumber(String mobileNumber);
}
