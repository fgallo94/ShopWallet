package com.fgallo.shopwallet.service;

import com.fgallo.shopwallet.controller.category.CategoryController;
import com.fgallo.shopwallet.entity.Category;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryService {

    private final CategoryController controller;

    public CategoryService() {
        this.controller = new CategoryController();
    }

    @GetMapping("/")
    public List<Category> getAll() {
        return controller.getAllCategory();
    }

    @PostMapping("/{idCategory}/{idItem}")
    public Category addItemToCategory(@PathVariable Long idCategory, @PathVariable Long idItem) {
        return controller.addItemToCategory(idCategory, idItem);
    }

    @PostMapping("/")
    public Category newCategory(@RequestBody Category newCategory) {
        return controller.newCategory(newCategory);
    }

    @GetMapping("/{id}")
    public Category getOne(@PathVariable Long id) {
        return controller.findByIdCategory(id);
    }

    @PutMapping("/{id}")
    public Category replaceCategory(@RequestBody Category newCategory, @PathVariable Long id) {
        return controller.replaceCategory(newCategory, id);
    }

    @DeleteMapping("/{id}")
    public void deleteOne(@PathVariable Long id) {
        controller.deleteByIdCategory(id);
    }
}
