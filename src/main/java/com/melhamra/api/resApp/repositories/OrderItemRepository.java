package com.melhamra.api.resApp.repositories;

import com.melhamra.api.resApp.entities.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity, Long> {
}
