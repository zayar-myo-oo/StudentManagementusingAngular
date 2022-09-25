package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Course;
import com.example.demo.exception.ResourseIdNotFoundException;
import com.example.demo.repo.CourseRepo;


@Service
public class CourseService {
	
	@Autowired
	CourseRepo repo;
	
	
	public Course insertCourse(Course cou) {
		return repo.save(cou);
	}
	
	public List<Course> showAllCourse() {
		return (List<Course>) repo.findAll();
	}
	
	public int maxIdCourse() {
		return repo.getMaxIdButIncreaseOne();
	}
	
public Course getById(int i) {
	return repo.findById(i)
			.orElseThrow(() -> new ResourseIdNotFoundException("User id not exists"+i));
}

//public void deleteCourse(Course cou) {
//repo.delete(cou);
//}

}
