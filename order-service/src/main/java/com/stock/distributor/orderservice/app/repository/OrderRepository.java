package com.stock.distributor.orderservice.app.repository;

import com.stock.distributor.orderservice.app.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
