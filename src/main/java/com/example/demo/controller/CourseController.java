package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Course;
import com.example.demo.service.CourseService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/")
public class CourseController {
	
	@Autowired
	CourseService service;
	

	@GetMapping("/courses")
	@ResponseStatus(value = HttpStatus.OK)
	public List<Course> showAllCourse() {
		return service.showAllCourse();
	}
	
	@PostMapping("/courses")
	@ResponseStatus(value = HttpStatus.CREATED)
	public Course addCourse(@RequestBody Course cu) {
		return service.insertCourse(cu);
	}
	
	@GetMapping("/courses/max")
	@ResponseStatus(value = HttpStatus.OK)
	public int showMaxIdCourse() {
		return service.maxIdCourse();
	}
	

}
