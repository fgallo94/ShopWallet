package com.fgallo.shopwallet.service;

import com.fgallo.shopwallet.controller.item.ItemNotFoundException;
import com.fgallo.shopwallet.entity.Category;
import com.fgallo.shopwallet.entity.Item;
import com.fgallo.shopwallet.repository.CategoryRepository;
import com.fgallo.shopwallet.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CategoryService categoryService;

    public List<Item> getAll() {
        return itemRepository.findAll();
    }

    public Item newItem(Item newItem) {
        return itemRepository.save(newItem);
    }

    public Item getByIdItem(Long id) {
        return itemRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
    }

    public Item replaceItem(Item newItem, Long id) {
        return itemRepository.findById(id)
                .map(item -> {
                    item.setCode(newItem.getCode());
                    item.setDescription(newItem.getDescription());
                    item.setPrice(newItem.getPrice());
                    return itemRepository.save(item);
                }).orElseGet(() -> {
                    newItem.setInternalCode(id);
                    return itemRepository.save(newItem);
                });
    }

    public void deleteById(Long id) {
        itemRepository.deleteById(id);
    }

}

