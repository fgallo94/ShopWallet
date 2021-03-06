package com.fgallo.shopwallet.controller.category;

import com.fgallo.shopwallet.entity.Category;
import com.fgallo.shopwallet.entity.Item;
import com.fgallo.shopwallet.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("category")
@CrossOrigin
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @GetMapping("/")
    public Page<Category> getAll() {
        return categoryService.getAllCategory();
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

    @PostMapping("/{idCategory}/{idItem}")
    public Category addItemToCategory(@PathVariable Long idCategory, @PathVariable Long idItem) {
        return categoryService.addItemToCategory(idCategory, idItem);
    }

    @DeleteMapping("/{idCategory}/{idItem}")
    public Category removeItemFromCategory(@PathVariable Long idCategory, @PathVariable Long idItem) {
        return categoryService.removeItemFromCategory(idCategory, idItem);
    }

    @GetMapping("/{id}/items")
    public Page<Item> getAllItemsFromCategory(@PathVariable Long id) {
        return categoryService.getAllItemsFromCategory(id);
    }

}


