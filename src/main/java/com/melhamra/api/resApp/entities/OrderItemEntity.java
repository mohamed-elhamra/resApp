package com.melhamra.api.resApp.entities;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "orders_items")
@Data
public class OrderItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    @ManyToOne @JoinColumn(name = "item_id")
    private ItemEntity item;

}
