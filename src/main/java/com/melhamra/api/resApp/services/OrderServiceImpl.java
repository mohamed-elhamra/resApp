package com.melhamra.api.resApp.services;

import com.melhamra.api.resApp.dtos.CustomerDto;
import com.melhamra.api.resApp.dtos.ItemDto;
import com.melhamra.api.resApp.dtos.OrderDto;
import com.melhamra.api.resApp.entities.CustomerEntity;
import com.melhamra.api.resApp.entities.ItemEntity;
import com.melhamra.api.resApp.entities.OrderEntity;
import com.melhamra.api.resApp.entities.OrderItemEntity;
import com.melhamra.api.resApp.repositories.CustomerRepository;
import com.melhamra.api.resApp.repositories.ItemRepository;
import com.melhamra.api.resApp.repositories.OrderItemRepository;
import com.melhamra.api.resApp.repositories.OrderRepository;
import com.melhamra.api.resApp.requests.OrderRequest;
import org.dom4j.rule.Mode;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService{
    
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    
    public List<OrderDto> getAllOrders(){
        List<OrderDto> orders = orderRepository.findAll().stream()
                .map(order -> new ModelMapper().map(order, OrderDto.class))
                .collect(Collectors.toList());
        return orders;
    }

    @Override
    public OrderDto saveOrder(OrderRequest orderRequest) {
        OrderDto orderDto = new ModelMapper().map(orderRequest, OrderDto.class);
        CustomerEntity customerEntity = customerRepository.findById(orderRequest.getCustomerId())
                                        .orElseThrow(() -> new RuntimeException("Customer doesn't exist with this id: "+orderRequest.getCustomerId()));
        orderDto.setCustomer(new ModelMapper().map(customerEntity, CustomerDto.class));
        OrderEntity orderEntity = new ModelMapper().map(orderDto, OrderEntity.class);
        for(int i = 0; i < orderRequest.getOrderItem().size(); i++) {
            OrderItemEntity orderItemEntity = new OrderItemEntity();
            orderItemEntity.setQuantity(orderRequest.getOrderItem().get(i).getQuantity());
            orderItemEntity.setOrder(orderEntity);

            ItemEntity item = itemRepository.findById(orderRequest.getOrderItem().get(i).getItemId())
                    .orElseThrow(() -> new RuntimeException("Item doesn't exist with this id"));
            orderItemEntity.setItem(item);
            orderEntity.getOrderItem().set(i, orderItemEntity);
        }
        orderRepository.save(orderEntity);
        return orderDto;
    }

    @Override
    public OrderDto getOrderById(long id) {
        OrderEntity orderEntity = orderRepository.findById(id)
                                    .orElseThrow(() -> new RuntimeException("Item doesn't exist with this id: " + id));
        return new ModelMapper().map(orderEntity, OrderDto.class);
    }

}
