package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface orderRepo extends JpaRepository<orderModel,Long> {

	List<orderModel> findByUserId(Long userId);
	
	
}
