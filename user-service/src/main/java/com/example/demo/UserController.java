package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserController {

	@Autowired
	UserService service;
	
	
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody UserModel user) {
		String msg =  service.register(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(msg);
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody UserModel user) {
		return ResponseEntity.status(HttpStatus.OK).body(service.login(user)); 
	}
	
	
	@GetMapping("all")
	public List<UserModel> getall(){
		return service.getAll();
		
	}
	 @GetMapping("/{id}")
	    public UserModel getById(@PathVariable Long id) {
	        return service.getById(id);
	    }
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<String> deleteUser(@PathVariable Long id) {
		 return ResponseEntity.status(HttpStatus.OK).body(service.deleteUser(id));
		 
	 }
	
}
