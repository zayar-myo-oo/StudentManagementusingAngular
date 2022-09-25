package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.User;

import com.example.demo.repo.UserRepo;

@Service
public class UserService {
@Autowired
UserRepo repo;
	
	public User insertUser(User user) {
		return repo.save(user);
	}
	public void deleteUserById(int id) {
		repo.deleteById(id);
	}
	
	
	public int getMaxId() {
		return repo.getMaxId();
	}
	
	public User updateUser(User user) {
		return repo.save(user);
	}
//	Iterable User
	//Optional User
	
	public List<User> showAllUser(){
		return (List<User>)repo.findAll();  
	}
//	public Optional<User> showUserById(int id) {
//		return repo.findById(id);
//	}
//	public User findUserById(int id) {
//		return  repo.findById(id)
//				.orElseThrow(() -> new ResourseIdNotFoundException("User id not exists"+id));
//	}
//	
//	public List<User> findUserByName(String name) {
//		return repo.findByName(name);
//				//				.orElseThrow(() -> new ResourseIdNotFoundException("User id not exists"+name));
//	}
	
//	public List<User> search(User et){
//        if(et.getId() !=null) {
//            return repo.findByidLike(et.getId());
//        }
//        if(!et.getName().equals("") && et.getName() != null) {
//            return repo.findBynameLike(et.getName());
//        }
//        return repo.findByIdAndName(et.getName(),et.getId());
//    }
	
//	public List<User> search(int id,String name ){
//        if(id !=0) {
//            return repo.findByidLike(id);
//        }
//        if(!name.equals("") && name != null) {
//            return repo.findBynameLike(name);
//        }
//        return repo.findByIdOrName(id,name);
//    }

	public List<User> search(int id,String name){
		return repo.findByIdOrName(id,name);	
	}
	
	
	
//	public User authtentication(int a,String b){
//		return repo.findByIdAndPassword(a,b);
//	}
	public User getById(int a){
		return repo.findByid(a);
	}

}
