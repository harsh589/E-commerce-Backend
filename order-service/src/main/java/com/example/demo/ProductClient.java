package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "PRODUCT-SERVICE")
public interface ProductClient {

    @GetMapping("/products/{id}")
    productDTO getProduct(@PathVariable Long id ,  @RequestHeader("Authorization") String token);
    
    
    @PutMapping("/products/reduceStock")
    String reduceStock(@RequestParam Long productId,
                       @RequestParam int quantity,  @RequestHeader("Authorization") String token);
}

