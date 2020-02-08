package com.kyanja.service;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyanja.model.Order;
import com.kyanja.repository.OrderRepository;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
 
    // orderRepository constructor injection
	
	@Autowired
	OrderRepository orderRepository;
 
    @Override
    public Iterable<Order> getAllOrders() {
        return this.orderRepository.findAll();
    }
     
    @Override
    public Order create(Order order) {
        order.setDateCreated(LocalDate.now());
        return this.orderRepository.save(order);
    }
 
    @Override
    public void update(Order order) {
        this.orderRepository.save(order);
    }
}
