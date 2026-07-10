package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	public String registerUser(@RequestBody UserModel user) {
		return service.register(user);
	}
	
	
	@PostMapping("/login")
	public String loginUser(@RequestBody UserModel user) {
		return service.login(user);
	}
	
	
	@PostMapping
	public UserModel addUser(@RequestBody UserModel user) {
		 return service.saveUser(user);
		 
	}
	
	@GetMapping
	public List<UserModel> getall(){
		return service.getAll();
		
	}
	 @GetMapping("/{id}")
	    public UserModel getById(@PathVariable Long id) {
	        return service.getById(id);
	    }
	 
	 @DeleteMapping("/{id}")
	 public String deleteUser(@PathVariable Long id) {
		 return service.deleteUser(id);
		 
	 }
	
}
