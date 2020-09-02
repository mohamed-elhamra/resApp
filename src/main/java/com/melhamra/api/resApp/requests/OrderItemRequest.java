package com.melhamra.api.resApp.requests;

import lombok.Data;

@Data
public class OrderItemRequest {
    private long id;
    private long orderId;
    private String itemName;
    private long itemId;
    private float price;
    private int quantity;
    private float total;
}
