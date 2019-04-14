package com.fgallo.shopwallet.controller.category;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(Long id) {
        super("Could not found category: " + id);
    }
}
