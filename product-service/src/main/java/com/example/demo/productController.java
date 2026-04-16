package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class productController {

    @Autowired
    private productService service;

    @PostMapping
    public productModel save(@RequestBody productModel product) {
        return service.save(product);
    }

    // get all
    @GetMapping
    public List<productModel> getAll() {
        return service.getAllProducts();
    }

    // get by id (IMPORTANT ✅)
    @GetMapping("/{id}")
    public productModel getById(@PathVariable Long id) {
        return service.getById(id);
    }
    
    //reduce stock
    @PutMapping("/reduceStock")
    public String reduceStock(@RequestParam Long productId,
            @RequestParam int quantity) {

return service.reduceStock(productId, quantity);}
}