package com.fgallo.shopwallet.controller.item;

import com.fgallo.shopwallet.entity.Item;
import com.fgallo.shopwallet.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("item")
public class ItemController {

    @Autowired
    private ItemRepository repository;

    @GetMapping("/")
    private List<Item> getAll() {
        return repository.findAll();
    }

    @PostMapping("/")
    private Item newItem(@RequestBody Item newItem) {
        return repository.save(newItem);
    }

    @GetMapping("/{id}")
    private Item getOne(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
    }

    @PutMapping("/{id}")
    private Item replaceItem(@RequestBody Item newItem, @PathVariable Long id) {
        return repository.findById(id)
                .map(item -> {
                    item.setCode(newItem.getCode());
                    item.setDescription(newItem.getDescription());
                    item.setPrice(newItem.getPrice());
                    return repository.save(item);
                }).orElseGet(() -> {
                    newItem.setInternalCode(id);
                    return repository.save(newItem);
                });
    }

    @DeleteMapping("/{id}")
    private void deleteOne(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
