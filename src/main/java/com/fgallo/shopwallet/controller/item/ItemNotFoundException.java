package com.fgallo.shopwallet.controller.item;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(Long id) {
        super("Could not found item: " + id);
    }
}
