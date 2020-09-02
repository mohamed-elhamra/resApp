package com.melhamra.api.resApp.services;

import com.melhamra.api.resApp.dtos.CustomerDto;

import java.util.List;

public interface CustomerService {

    List<CustomerDto> getAllCustomers();

}
