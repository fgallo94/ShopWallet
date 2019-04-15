package com.fgallo.shopwallet.controller.category;

import com.fgallo.shopwallet.entity.Category;
import com.fgallo.shopwallet.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @GetMapping("/")
    public List<Category> getAll() {
        return categoryService.getAllCategory();
    }

    @PostMapping("/{idCategory}/{idItem}")
    public Category addItemToCategory(@PathVariable Long idCategory, @PathVariable Long idItem) {
        return categoryService.addItemToCategory(idCategory, idItem);
    }

    @PostMapping("/")
    public Category newCategory(@RequestBody Category newCategory) {
        return categoryService.newCategory(newCategory);
    }

    @GetMapping("/{id}")
    public Category getOne(@PathVariable Long id) {
        return categoryService.findByIdCategory(id);
    }

    @PutMapping("/{id}")
    public Category replaceCategory(@RequestBody Category newCategory, @PathVariable Long id) {
        return categoryService.replaceCategory(newCategory, id);
    }

    @DeleteMapping("/{id}")
    public void deleteOne(@PathVariable Long id) {
        categoryService.deleteByIdCategory(id);
    }
}


