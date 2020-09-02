package com.melhamra.api.resApp.services;


import com.melhamra.api.resApp.dtos.CustomerDto;
import com.melhamra.api.resApp.entities.CustomerEntity;
import com.melhamra.api.resApp.repositories.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<CustomerDto> customers = customerRepository.findAll().stream()
                                    .map(customer -> new ModelMapper().map(customer, CustomerDto.class))
                                    .collect(Collectors.toList());
        return customers;
    }
}
