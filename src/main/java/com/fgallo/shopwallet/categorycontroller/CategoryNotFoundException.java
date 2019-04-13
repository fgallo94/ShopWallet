package com.fgallo.shopwallet.categorycontroller;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(Long id) {
        super("Could not found category: " + id);
    }
}
