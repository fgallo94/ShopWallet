package com.fgallo.shopwallet.controller.category;

import com.fgallo.shopwallet.controller.item.ItemNotFoundException;
import com.fgallo.shopwallet.entity.Category;
import com.fgallo.shopwallet.repository.CategoryRepository;
import com.fgallo.shopwallet.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ItemRepository itemRepository;

    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    public Category newCategory(Category newCategory) {
        return categoryRepository.save(newCategory);
    }

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

    public void deleteByIdCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    public Category addItemToCategory(Long idCategory, Long idItem) {
        return categoryRepository.findById(idCategory)
                .map(category -> {
                    category.getItemList().add(itemRepository.findById(idItem).orElseThrow(() -> new ItemNotFoundException(idItem)));
                    return categoryRepository.save(category);
                }).orElseThrow(() -> new CategoryNotFoundException(idCategory));
    }

}
