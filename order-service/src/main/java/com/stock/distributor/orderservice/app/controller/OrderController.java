package com.stock.distributor.orderservice.app.controller;

import com.stock.distributor.orderservice.app.dto.OrderRequest;
import com.stock.distributor.orderservice.app.dto.OrderResponse;
import com.stock.distributor.orderservice.app.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest) {
        return orderService.placeOrder(orderRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderResponse> getAllProducts() {
        return orderService.getAllOrders();
    }
}
