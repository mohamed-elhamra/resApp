package com.melhamra.api.resApp.controllers;

import com.melhamra.api.resApp.dtos.ItemDto;
import com.melhamra.api.resApp.responses.ItemResponse;
import com.melhamra.api.resApp.services.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public ResponseEntity<?> getItems(){
        List<ItemResponse> items = itemService.getAllItems().stream()
                                    .map(item -> new ModelMapper().map(item, ItemResponse.class))
                                    .collect(Collectors.toList());
        return ResponseEntity.ok(items);
    }

}
