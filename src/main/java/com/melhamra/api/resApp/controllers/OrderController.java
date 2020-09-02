package com.melhamra.api.resApp.controllers;


import com.melhamra.api.resApp.dtos.OrderDto;
import com.melhamra.api.resApp.requests.OrderRequest;
import com.melhamra.api.resApp.responses.OrderResponse;
import com.melhamra.api.resApp.services.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<?> getOrders(){
        List<OrderResponse> orders = orderService.getAllOrders().stream()
                .map(order -> new ModelMapper().map(order, OrderResponse.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable long id){
        OrderDto orderDto = orderService.getOrderById(id);
        return ResponseEntity.ok(new ModelMapper().map(orderDto, OrderResponse.class));
    }

    @PostMapping
    public ResponseEntity<?> saveOrder(@RequestBody OrderRequest orderRequest){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ModelMapper().map(orderService.saveOrder(orderRequest), OrderResponse.class));
    }
    
}
