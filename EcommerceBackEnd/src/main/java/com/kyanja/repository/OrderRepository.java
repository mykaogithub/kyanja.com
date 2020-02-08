package com.kyanja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kyanja.model.Order;



public interface OrderRepository extends  JpaRepository<Order, Long> {

}
