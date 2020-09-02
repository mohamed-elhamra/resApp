package com.melhamra.api.resApp.entities;

import jdk.jfr.Enabled;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name = "items")
@Data
public class ItemEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private float price;

    @OneToMany(mappedBy = "item")
    private List<OrderItemEntity> orderItem;

}
