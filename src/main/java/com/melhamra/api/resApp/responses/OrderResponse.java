package com.melhamra.api.resApp.responses;

import com.melhamra.api.resApp.dtos.OrderItemDto;
import lombok.Data;

import java.util.List;


@Data
public class OrderResponse {

    private long id;
    private String orderNo;
    private String method;
    private float total;
    private CustomerResponse customer;
    private List<OrderItemResponse> orderItem;
}

