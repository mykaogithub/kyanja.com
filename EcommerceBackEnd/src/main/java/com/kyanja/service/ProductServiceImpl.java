package com.kyanja.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyanja.exception.ResourceNotFoundException;
import com.kyanja.model.Product;
import com.kyanja.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
 
    // productRepository constructor injection
	
	
	@Autowired 
	
	ProductRepository productRepository;
 
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }
 
    public Product getProduct(long id) throws ResourceNotFoundException {
        return productRepository
          .findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }
 
    public Product save(Product product) {
        return productRepository.save(product);
    }
}