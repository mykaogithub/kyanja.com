package com.kyanja.repository;


import org.springframework.data.repository.CrudRepository;

import com.kyanja.model.OrderProduct;
import com.kyanja.model.OrderProductPK;

public interface OrderProductRepository extends CrudRepository<OrderProduct, OrderProductPK> {
}
