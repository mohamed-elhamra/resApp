package com.melhamra.api.resApp.requests;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {

    private long id;
    private String orderNo;
    private String method;
    private float total;
    private long customerId;
    private List<OrderItemRequest> orderItem;

}
