package com.fgallo.shopwallet.service;

import com.fgallo.shopwallet.controller.category.CategoryNotFoundException;
import com.fgallo.shopwallet.controller.item.ItemNotFoundException;
import com.fgallo.shopwallet.entity.Category;
import com.fgallo.shopwallet.entity.Item;
import com.fgallo.shopwallet.repository.CategoryRepository;
import com.fgallo.shopwallet.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class CategoryService {

    Pageable sortedByItemCode =
            PageRequest.of(0, 3);

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ItemRepository itemRepository;


    public Category findByIdCategory(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException(id));
    }

    public Category replaceCategory(Category newCategory, Long id) {
        return categoryRepository.findById(id)
                .map(category -> {
                    category.setCode(newCategory.getCode());
                    category.setDescription(newCategory.getDescription());
                    return categoryRepository.save(category);
                }).orElseGet(() -> {
                    newCategory.setInternalCode(id);
                    return categoryRepository.save(newCategory);
                });
    }

    public Category addItemToCategory(Long idCategory, Long idItem) {
        return categoryRepository.findById(idCategory)
                .map(category -> {
                    Item item = itemRepository.findById(idItem)
                            .orElseThrow(() -> new ItemNotFoundException(idItem));
                    item.setCategory(category);
                    itemRepository.save(item);
                    return category;
                })
                .orElseThrow(() -> new CategoryNotFoundException(idCategory));
    }

    public Category removeItemFromCategory(Long idCategory, Long idItem) {
        return categoryRepository.findById(idCategory)
                .map(category -> {
                    Item item = itemRepository.findById(idItem).orElseThrow(() -> new ItemNotFoundException(idItem));
                    item.setCategory(null);
                    itemRepository.save(item);
                    return category;
                }).orElseThrow(() -> new CategoryNotFoundException(idCategory));
    }

    public Page<Item> getAllItemsFromCategory(Long idCategory) {
        return categoryRepository.findAllItemsFromCategory(idCategory, sortedByItemCode);
    }

}
