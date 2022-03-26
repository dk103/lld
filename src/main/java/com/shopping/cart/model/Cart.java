package com.shopping.cart.model;

public interface Cart {

    void addItem(CartItem item);

    double checkout();
}
