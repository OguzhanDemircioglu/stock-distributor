package com.stock.distributor.orderservice.app.dto;

import java.math.BigDecimal;

public record OrderResponse(String orderNumber, String skuCode, BigDecimal price, Integer quantity) {
}