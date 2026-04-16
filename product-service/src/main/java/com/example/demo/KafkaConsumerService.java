package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @Autowired
    private productRepo productRepo;

    @KafkaListener(topics = "order-topic", groupId = "product-group")
    public void consume(OrderEvent event) {

        productModel product = productRepo.findById(event.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setStock(product.getStock() - event.getQuantity());

        productRepo.save(product);

        System.out.println("✅ Stock updated via Kafka");
    }
}