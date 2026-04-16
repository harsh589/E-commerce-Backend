package com.example.demo;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "USER-SERVICE")
public interface UserClient {

	@GetMapping("/auth/{id}")
	userDTO getUser(
	        @PathVariable Long id,
	        @RequestHeader("Authorization") String token // ✅ ADD
	);
    
}