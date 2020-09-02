package com.melhamra.api.resApp.services;

import com.melhamra.api.resApp.dtos.ItemDto;
import com.melhamra.api.resApp.repositories.ItemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<ItemDto> getAllItems(){
        List<ItemDto> items = itemRepository.findAll().stream()
                                .map(item -> new ModelMapper().map(item, ItemDto.class))
                                .collect(Collectors.toList());
        return items;
    }

}
