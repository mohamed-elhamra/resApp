package com.melhamra.api.resApp.dtos;

import lombok.Data;


@Data
public class OrderItemDto {

    private long id;
    private int quantity;
    private OrderDto order;
    private ItemDto item;

}
