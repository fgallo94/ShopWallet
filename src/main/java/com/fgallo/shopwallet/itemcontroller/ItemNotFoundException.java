package com.fgallo.shopwallet.itemcontroller;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(Long id) {
        super("Could not found item: " + id);
    }
}
