package com.fgallo.shopwallet.controller.category;

import com.fgallo.shopwallet.entity.Category;
import com.fgallo.shopwallet.entity.Item;
import com.fgallo.shopwallet.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Item> getAllItemsFromCategory(@PathVariable Long id) {
        return categoryService.getAllItemsFromCategory(id);
    }

}


