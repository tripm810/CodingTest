package com.coding.test.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coding.test.model.User;
import com.coding.test.repository.UserRepository;
import com.coding.test.service.UserService;

@RestController
public class RestfulController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@GetMapping("/findall")
	public List<User> retrieveAllUsers() {
		return userService.findAll();
	}

	@GetMapping("/find/{id}")
	public User retrieveUser(@PathVariable long id) throws Exception {
		Optional<User> user = userService.findById(id);

		if (!user.isPresent())
			throw new Exception("User with id = " + id + " not exists");

		return user.get();
	}

	@DeleteMapping("/deleteuser/{id}")
	public void deleteUser(@PathVariable long id) {
		if (userRepository.findById(id).isPresent()) {
			userRepository.deleteById(id);
		}
	}

	@PostMapping("/createuser")
	public void createuser(@RequestBody User user) {
		userService.saveUser(user);
	}

	@PutMapping("/updateuser/{id}")
	public ResponseEntity<Object> updateUser(@RequestBody User user, @PathVariable long id) {

		Optional<User> studentOptional = userRepository.findById(id);

		if (!studentOptional.isPresent())
			return ResponseEntity.notFound().build();

		user.setId(id);

		userService.saveUser(user);

		return ResponseEntity.noContent().build();
	}
}