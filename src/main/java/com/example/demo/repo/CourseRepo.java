package com.example.demo.repo;


import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.Course;

@Repository
public interface CourseRepo extends CrudRepository<Course, Integer>{

//	@Query(value="SELECT max(cid) as maxid FROM course",nativeQuery=true)
	@Query(value="SELECT COALESCE(MAX(cid),0)+1 FROM course",nativeQuery=true)
	int getMaxIdButIncreaseOne();	
	
	Optional<Course> findById(int i);
	
}
