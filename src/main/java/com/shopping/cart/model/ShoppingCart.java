package com.shopping.cart.model;

import java.util.*;

public class ShoppingCart implements Cart {

    private List<CartItem> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    @Override
    public void addItem(CartItem item) {
        this.items.add(item);
    }

    @Override
    public double checkout() {

        double finalAmt = 0d;
        applyAllCouponToProductItem();

        for (CartItem item : items) {
            if (item.isCoupon()) {
                continue;
            }
            Product product = (Product) item;
            finalAmt += product.getDiscountedPrice();
        }
        return finalAmt;
    }

    private void applyAllCouponToProductItem() {

        int currentIndex = 0;

        for (CartItem item : items) {
            if (!item.isCoupon()) {
                currentIndex++;
                continue;
            }
            Coupon coupon = (Coupon) item;
            coupon.applyToProducts(items, currentIndex);
            currentIndex++;
        }

    }

}
