package com.melhamra.api.resApp.responses;

import lombok.Data;

@Data
public class OrderItemResponse {

    private long id;
    private int quantity;
    private ItemResponse item;

}
