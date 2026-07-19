package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "poduct_service")
public class productModel {

	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

@NotNull(message="name can not be empty")
    private String name;

    private double price;
    private int stock;
    
    //this is for the transactional 	
    @Version
    private Long version;
    
    
	public productModel() {
		super();
	}
	public productModel(Long id, String name, double price, int stock) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "productModel [id=" + id + ", name=" + name + ", price=" + price + ", stock=" + stock + "]";
	}
    
    
	
}
