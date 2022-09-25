package com.example.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Student;
import com.example.demo.repo.StudentRepo;


@Service
public class StudentService {

	@Autowired
	StudentRepo repo;
	
		public Student saveStu(Student stu) {
			return repo.save(stu);
		}
		
		public Student updateStu(Student stu) {
			return repo.save(stu);
		}
		public void deleteStuById(int id){
		 repo.deleteById(id);
			
		}
				
		public List<Student> showAllStudent(){
		return (List<Student>) repo.findAll();
		}
		
	
		public int getMaxId() {
			return repo.getMaxIdButIncreaseOne();
		}
		
		public Student getById(int id) {
			return repo.findByid(id);
		}
		
//		public List<Student> search(int id,String name,String coures){
//			return repo.findDistinctStudentByidOrnameOrcourse(id, name, coures);
//		}
		
//		public List<Student> searchUser(int id,String name,String coures){
//			return repo.findByIdOrNameOrCourse(id, name, coures);
//		}
		

	
		
}
