package com.fgallo.shopwallet.service;

import com.fgallo.shopwallet.controller.item.ItemController;
import com.fgallo.shopwallet.entity.Item;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("item")
public class ItemService {

    private final ItemController itemController;

    public ItemService() {
        this.itemController = new ItemController();
    }

    @GetMapping("/")
    public List<Item> getAll() {
        return itemController.getAll();
    }

    @PostMapping("/")
    public Item newItem(@RequestBody Item newItem) {
        return itemController.newItem(newItem);
    }

    @GetMapping("/{id}")
    public Item getOne(@PathVariable Long id) {
        return itemController.getByIdItem(id);
    }

    @PutMapping("/{id}")
    public Item replaceItem(@RequestBody Item newItem, @PathVariable Long id) {
        return itemController.replaceItem(newItem, id);
    }

    @DeleteMapping("/{id}")
    public void deleteOne(@PathVariable Long id) {
        itemController.deleteById(id);
    }

}
