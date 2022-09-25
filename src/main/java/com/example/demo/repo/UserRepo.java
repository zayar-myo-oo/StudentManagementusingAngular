package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.User;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {

	@Query(value = "select max(id) as maxid from user", nativeQuery = true)
	int getMaxId();
	
//	List<User> findByName(String name);
//	
//	Optional<User> findById(Integer id);

	List<User> findByidLike(Integer id);

	List<User> findBynameLike(String name);

	List<User> findByIdOrName( Integer id,String name);
	
//	@Query(value = "select * from user u where u.id=:a and u.password=:b", nativeQuery = true)
//	User findByidAndpassword(int a,String b);
	
	User findByid(int a);
	
}
