package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

	@Autowired
	private ProductClient productClient;

	@Autowired
	private UserClient userClient;
	@Autowired
	private orderRepo Repo;

	public orderResponseDto placeOrder(Long userId, Long productId , String token) {
		try {
			productDTO product = productClient.getProduct(productId , token);
			userDTO user = userClient.getUser(userId ,token);

			// 🔥 2. Stock reduce karo
			productClient.reduceStock(productId, 1, token);

			orderModel order = new orderModel();
			order.setUserId(userId);
			order.setProductId(productId);
			order.setProductName(product.getName());
			order.setPrice(product.getPrice());
			order.setUserName(user.getName());

			orderModel savedOrder = Repo.save(order);

			//

			return new orderResponseDto(savedOrder.getId(), user.getName(), product.getName(), product.getPrice());

		}

		catch (feign.FeignException.NotFound ex) {

			throw new RuntimeException("Product or User not found" + productId);

		}

	}

	public List<orderModel> getOrderbyuser(Long userId) {
		return Repo.findByUserId(userId);
	}

}