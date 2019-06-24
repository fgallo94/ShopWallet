package com.fgallo.shopwallet.controller.item;

import com.fgallo.shopwallet.entity.Item;
import com.fgallo.shopwallet.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/{id}")
    public Item getOne(@PathVariable Long id) {
        return itemService.getByIdItem(id);
    }

}
