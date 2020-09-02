package com.melhamra.api.resApp.controllers;


import com.melhamra.api.resApp.dtos.CustomerDto;
import com.melhamra.api.resApp.responses.CustomerResponse;
import com.melhamra.api.resApp.services.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<?> getCustomers(){
        List<CustomerResponse> customers = customerService.getAllCustomers().stream()
                                            .map(customer -> new ModelMapper().map(customer, CustomerResponse.class))
                                            .collect(Collectors.toList());
        return ResponseEntity.ok(customers);
    }

}
