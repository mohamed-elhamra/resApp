package com.melhamra.api.resApp.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name = "customers")
@Data
public class CustomerEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "customer")
    private List<OrderEntity> orders;

}