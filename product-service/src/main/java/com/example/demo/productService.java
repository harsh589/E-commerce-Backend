package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class productService {

	
@Autowired
productRepo repo;

// save product
public productModel save(productModel product) {
    return repo.save(product);
}



// get all products
public List<productModel> getAllProducts() {
    return repo.findAll();
}

// get product by id ✅
	
public productModel getById(Long id) {
    return repo.findById(id)
        .orElseThrow(() -> new ProductNotFoundException("Product not found with id " + id));
}

@PutMapping("/product/reduceStock")
public String reduceStock(@RequestParam Long id,
                          @RequestParam int quantity) {

   productModel product = repo.findById(id)
            .orElseThrow(() -> new RuntimeException("Product not found" + id));

    if(product.getStock() < quantity){
        throw new RuntimeException("Out of stock");
    }

    product.setStock(product.getStock() - quantity);
    repo.save(product);

    return "Stock updated";
}


}
