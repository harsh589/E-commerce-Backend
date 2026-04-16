package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class orderController {

	
	@Autowired
	OrderService service;
	
	@PostMapping("/order")
	public orderResponseDto order(
	        @RequestParam Long userId,
	        @RequestParam Long productId,
	        @RequestHeader("Authorization") String token // ✅ ADD THIS
	) {
	    return service.placeOrder(userId, productId, token); // ✅ pass token
	}
	
	
	@GetMapping("/orders")
public List<orderModel> getOrders(@RequestParam Long userId){
	return service.getOrderbyuser(userId);
	
}
	
	
	

}
