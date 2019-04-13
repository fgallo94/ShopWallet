package com.fgallo.shopwallet.categorycontroller;

import com.fgallo.shopwallet.entity.Category;
import com.fgallo.shopwallet.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {


    @Autowired
    private CategoryRepository repository;

    @GetMapping("/")
    private List<Category> getAll() {
        return repository.findAll();
    }

    @PostMapping("/")
    private Category newCategory(@RequestBody Category newCategory) {
        return repository.save(newCategory);
    }

    @GetMapping("/{id}")
    private Category getOne(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new CategoryNotFoundException(id));
    }

    @PutMapping("/{id}")
    private Category replaceCategory(@RequestBody Category newCategory, @PathVariable Long id) {
        return repository.findById(id)
                .map(category -> {
                    category.setCode(newCategory.getCode());
                    category.setDescription(newCategory.getDescription());
                    return repository.save(category);
                }).orElseGet(() -> {
                    newCategory.setInternalCode(id);
                    return repository.save(newCategory);
                });
    }

    @DeleteMapping("/{id}")
    private void deleteOne(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
