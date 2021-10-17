package com.example.momo.integration.service;

import com.example.momo.integration.dto.response.OrderResponse;

public interface OrderService {

    public OrderResponse findOrderById(String id);

}
