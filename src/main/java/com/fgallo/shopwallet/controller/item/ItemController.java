package com.fgallo.shopwallet.controller.item;

import com.fgallo.shopwallet.entity.Item;
import com.fgallo.shopwallet.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("item")
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/")
    public List<Item> getAll() {
        return itemService.getAll();
    }

    @PostMapping("/")
    public Item newItem(@RequestBody Item newItem) {
        return itemService.newItem(newItem);
    }

    @GetMapping("/{id}")
    public Item getOne(@PathVariable Long id) {
        return itemService.getByIdItem(id);
    }

    @PutMapping("/{id}")
    public Item replaceItem(@RequestBody Item newItem, @PathVariable Long id) {
        return itemService.replaceItem(newItem, id);
    }

    @DeleteMapping("/{id}")
    public void deleteOne(@PathVariable Long id) {
        itemService.deleteById(id);
    }

}
