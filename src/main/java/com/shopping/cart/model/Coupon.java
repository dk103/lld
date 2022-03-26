package com.shopping.cart.model;


import java.util.List;

public abstract class Coupon implements CartItem {

    private double discount;

    public Coupon(double discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public abstract Enums.CouponType  getCouponType();

    public void applyToProducts(List<CartItem> cartItems, int currentIndex) {
        process(cartItems,currentIndex);
    }

    protected abstract void process(List<CartItem> items, int currentIndex);


    public abstract Enums.DeductionType isDeductionType();

    @Override
    public boolean isCoupon() {
        return true;
    }
}
