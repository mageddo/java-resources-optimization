package com.mageddo.conciliation.api.controller;

import com.mageddo.conciliation.dao.UserRepository;
import com.mageddo.conciliation.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

	private UserRepository userRepository;

	@Autowired
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@GetMapping(value = "/users/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseEntity<UserEntity> getUser(@PathVariable("id") int userId){
		return ResponseEntity.ok(userRepository.getById(userId));
	}

	@GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody
	ResponseEntity<List<UserEntity>> getUsers(){
		return ResponseEntity.ok(userRepository.findAll());
	}
}
