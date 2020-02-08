package com.kyanja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kyanja.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
