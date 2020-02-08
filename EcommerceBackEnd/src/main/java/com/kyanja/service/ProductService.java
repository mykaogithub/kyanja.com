package com.kyanja.service;

import com.kyanja.exception.ResourceNotFoundException;
import com.kyanja.model.Product;

public interface ProductService {

	
	 public Iterable<Product> getAllProducts();
	 
	 public Product getProduct(long id) throws ResourceNotFoundException;
	 
	  public Product save(Product product);
}
