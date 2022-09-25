package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Student;
import com.example.demo.repo.StudentRepo;
import com.example.demo.service.ReportStudentService;
import com.example.demo.service.StudentService;

import net.sf.jasperreports.engine.JRException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class StudentController {

	@Autowired
	StudentService service;
	
	@Autowired
	StudentRepo repo;
	
	@Autowired
	ReportStudentService report;

	@GetMapping("/students")
	@ResponseStatus(value = HttpStatus.OK)
	public List<Student> getAllStudents() {
		 
		return service.showAllStudent();
	}
	
	@PostMapping("/students")
	@ResponseStatus(value = HttpStatus.CREATED)
	public Student createStudent(@RequestBody Student stu) {
		return service.saveStu(stu);
	}

	@PutMapping("/students")
	@ResponseStatus(value = HttpStatus.CREATED)
	public Student updateStudent(@RequestBody Student userReq) {
		return service.updateStu(userReq);
	}

	@DeleteMapping("/students/delete/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public void deleteStudent(@PathVariable("id") int id) {
		service.deleteStuById(id);
	}
	
	@GetMapping("/stusearch/{id}/{name}/{course}")
	@ResponseStatus(value = HttpStatus.OK)
    public List<Student> search(@PathVariable("id") int id,@PathVariable("name") String name,@PathVariable("course") String course){
        if(  id!=0) {
        	return repo.findByidLike(id);        	
        }
        
        if(name !=null && !name.equals("null") ) {
        	return repo.findBynameLike(name);
        }
        if(course !=null && !course.equals("null") ) {
        	return repo.findByCourse(course);
        }
        return (List<Student>)repo.findByIdAndName(id,name);   
	}
  
	@GetMapping("/students/report/{format}")
	public String generateReport(@PathVariable String format,HttpServletResponse reponse) throws JRException, IOException {
		if(format.equals("pdf")) {
			return report.exportPdfReport(format);	
		}
		return report.exportExcelReport(reponse);
		
	}	


	@GetMapping("/students/max")
	@ResponseStatus(value = HttpStatus.OK)
	public int stuMaxId() {
		return service.getMaxId();
	}
	

	@GetMapping("/students/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public Student login(@PathVariable("id")int id) {
		return service.getById(id);		
}
	
//	@GetMapping("/studentSearch/{id}/{name}/{course}")
//	@ResponseStatus(value = HttpStatus.OK)
//    public List<Student> searchStudent(@PathVariable("id") int id,@PathVariable("name") String name,@PathVariable("course") String course){
//        return service.searchUser(id,name,course);
//    }
}
