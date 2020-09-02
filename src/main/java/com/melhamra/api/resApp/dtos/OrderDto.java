package com.melhamra.api.resApp.dtos;

import lombok.Data;

import java.util.List;

@Data
public class OrderDto {

    private long id;
    private String orderNo;
    private String method;
    private float total;
    private CustomerDto customer;
    private List<OrderItemDto> orderItem;

}
