package com.coding.test.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.test.model.User;
import com.coding.test.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public void saveUser(User user) {
		userRepository.save(user);

	}

	@Override
	public List<User> findByEmail(String email) {
		List<User> list = new ArrayList<>();
		list.addAll(userRepository.findByEmail(email));
		return list;

	}

	@Override
	public List<User> findByMobileNumber(String mobileNumber) {
		List<User> list = new ArrayList<>();
		list.addAll(userRepository.findByMobileNumber(mobileNumber));
		return list;
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> findById(long id) {
		return userRepository.findById(id);
	}

}
