package com.coding.test.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.coding.test.model.User;

@Component
public interface UserService {

	public void saveUser(User user);

	public List<User> findByEmail(String email);

	public List<User> findByMobileNumber(String mobileNumber);

	public List<User> findAll();

	public Optional<User> findById(long id);

}