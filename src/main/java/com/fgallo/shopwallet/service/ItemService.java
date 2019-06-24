package com.fgallo.shopwallet.service;

import com.fgallo.shopwallet.controller.item.ItemNotFoundException;
import com.fgallo.shopwallet.entity.Item;
import com.fgallo.shopwallet.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Item getByIdItem(Long id) {
        return itemRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
    }

}

