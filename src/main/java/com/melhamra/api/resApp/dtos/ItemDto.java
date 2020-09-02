package com.melhamra.api.resApp.dtos;

import com.melhamra.api.resApp.entities.OrderItemEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class ItemDto {

    private long id;
    private String name;
    private float price;
    private List<OrderItemDto> orderItem;

}
