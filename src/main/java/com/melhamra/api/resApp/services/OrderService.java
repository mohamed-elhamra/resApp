package com.melhamra.api.resApp.services;

import com.melhamra.api.resApp.dtos.OrderDto;
import com.melhamra.api.resApp.requests.OrderRequest;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    List<OrderDto> getAllOrders();

    OrderDto saveOrder(OrderRequest orderDto);

    OrderDto getOrderById(long id);
}
