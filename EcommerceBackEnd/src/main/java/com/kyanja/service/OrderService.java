package com.kyanja.service;

import com.kyanja.model.Order;

public interface OrderService {
	
	   public Iterable<Order> getAllOrders() ;
	   
	   public Order create(Order order);
	   
	    public void update(Order order);

}
