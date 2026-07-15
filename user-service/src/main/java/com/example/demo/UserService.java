package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	
	public UserService(UserRepo repo, PasswordEncoder encoder, JwtUtil util) {
	    this.repo = repo;
	    this.encoder = encoder;
	    this.util = util;
	}

	@Autowired
	UserRepo repo;
	
	@Autowired
	JwtUtil util;
	
	@Autowired
	PasswordEncoder encoder;	
	
	
	//register
	 public String register(UserModel user) {

   	  user.setPassword(encoder.encode(user.getPassword()));
         repo.save(user);
         return "User Registered";
     }
	

    // Login
    public String login(UserModel user) {

        UserModel existing = repo.findByEmail(user.getEmail());

        if (existing != null && encoder.matches(user.getPassword(), existing.getPassword())) {
            return util.generateToken(user.getEmail());
        }

        throw new LoginFailed("Invalid credentials please enter correct email and password");
    }
	
	
	
   
	
	public UserModel saveUser(UserModel user) {
		return repo.save(user);
	}
	
	public List<UserModel> getAll(){
		return repo.findAll();
	}
	
	public UserModel getById(Long id) {
	    return repo.findById(id)
	            .orElseThrow(() -> new RuntimeException("Product not found"));
	}
	
	public String deleteUser(Long id) {
		repo.deleteById(id);
		return "user of id " + id + " is deleted";
	}
	
}
