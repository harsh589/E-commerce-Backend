package com.example.demo;

public class OrderEvent {
	 private Long productId;
	    private int quantity;

	    public OrderEvent() {}

	    public OrderEvent(Long productId, int quantity) {
	        this.productId = productId;
	        this.quantity = quantity;
	    }

	    public Long getProductId() {
	        return productId;
	    }

	    public void setProductId(Long productId) {
	        this.productId = productId;
	    }

	    public int getQuantity() {
	        return quantity;
	    }

	    public void setQuantity(int quantity) {
	        this.quantity = quantity;
	    }
}
