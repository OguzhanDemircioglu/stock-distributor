package com.stock.distributor.orderservice.app.service;

import com.stock.distributor.orderservice.app.client.InventoryClient;
import com.stock.distributor.orderservice.app.dto.OrderRequest;
import com.stock.distributor.orderservice.app.dto.OrderResponse;
import com.stock.distributor.orderservice.app.model.Order;
import com.stock.distributor.orderservice.app.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;

    public String placeOrder(OrderRequest orderRequest) {

        boolean returnValue = inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());

        if (returnValue) {
            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setPrice(orderRequest.price().multiply(BigDecimal.valueOf(orderRequest.quantity())));
            order.setSkuCode(orderRequest.skuCode());
            order.setQuantity(orderRequest.quantity());
            orderRepository.save(order);
            return "Order Placed Successfully";
        } else {
            return "Product with sku code " + orderRequest.skuCode() + " is not in stock";
        }
    }

    public List<OrderResponse> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(data -> new OrderResponse(
                        data.getOrderNumber(),
                        data.getSkuCode(),
                        data.getPrice(),
                        data.getQuantity()))
                .toList();
    }
}