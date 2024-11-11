package com.stock.distributor.productservice.app.repository;

import com.stock.distributor.productservice.app.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
