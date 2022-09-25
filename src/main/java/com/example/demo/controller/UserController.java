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

import com.example.demo.dto.User;
import com.example.demo.service.ReportUserService;
import com.example.demo.service.UserService;

import net.sf.jasperreports.engine.JRException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserService service;
@Autowired
ReportUserService report;

	@GetMapping("/users")
	public List<User> getAllUsers() {
		List<User> user = service.showAllUser();
		return user;
	}
		
	@GetMapping("/usersearch/{id}/{name}")
	@ResponseStatus(value = HttpStatus.OK)
    public List<User> search(@PathVariable("id") int id,@PathVariable("name") String name){
        return service.search(id,name);
    }


	@PostMapping("/users")
	@ResponseStatus(value = HttpStatus.CREATED)
	public User createUser(@RequestBody User user) {
		User newUser = service.insertUser(user);
		return newUser;
	}


	@PutMapping("/users")
	@ResponseStatus(value = HttpStatus.CREATED)
	public User updateUser(@RequestBody User userReq) {
		User updateUser = service.insertUser(userReq);
		return updateUser;
	}


	@DeleteMapping("/users/delete/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public void deleteUser(@PathVariable("id") int id) {
		service.deleteUserById(id);
		
	}
	
	@GetMapping("/users/max")
	@ResponseStatus(value = HttpStatus.OK)
	public int UserMaxId() {
		return service.getMaxId();
	}

	@GetMapping("/users/report/{format}")
	public String generateReport(@PathVariable String format,HttpServletResponse reponse) throws JRException, IOException {
		if(format.equals("pdf")) {
			return report.exportPdfReport(format);	
		}
		return report.exportExcelReport(reponse);
		
	}
	
//	@GetMapping("/usersearch")
//	@ResponseStatus(value = HttpStatus.OK)
//    public List<User> search(@RequestBody User et){
//        return service.search(et);
//    }
//	@DeleteMapping("/users/delete/{id}")
//	@ResponseStatus(value = HttpStatus.OK)
//	public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable("id") int id) {
//		service.deleteUserById(id);
//		Map<String, Boolean> response = new HashMap<>();
//		response.put("deleted", Boolean.TRUE);
//		return ResponseEntity.ok(response);
//	}
}
