package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.User;
import com.example.demo.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class LogininOutController {

	@Autowired
	UserService repo;
	
//	@GetMapping("/login")
//	@ResponseStatus(value = HttpStatus.CREATED)
//	public User login(@RequestBody User u) {
//		return repo.authtentication(u.getId(), u.getPassword());
//		
//	}
	
	@GetMapping("/login/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public User login(@PathVariable("id")int id) {
		return repo.getById(id);
		
	}
	}
