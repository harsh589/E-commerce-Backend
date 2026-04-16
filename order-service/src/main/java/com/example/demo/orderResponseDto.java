package com.example.demo;

public class orderResponseDto{

    private Long orderId;
    private String userName;
    private String productName;
    private double price;

    public orderResponseDto(Long orderId, String userName, String productName, double price) {
        this.orderId = orderId;
        this.userName = userName;
        this.productName = productName;
        this.price = price;
    }

    public Long getOrderId() {
        return orderId;
    }

    public String getUserName() {
        return userName;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }
}