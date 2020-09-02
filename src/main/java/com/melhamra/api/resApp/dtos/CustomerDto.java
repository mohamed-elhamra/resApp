package com.melhamra.api.resApp.dtos;

import com.melhamra.api.resApp.entities.OrderEntity;
import lombok.Data;

import java.util.List;

@Data
public class CustomerDto {

    private long id;
    private String name;
    private List<OrderDto> orders;

}
