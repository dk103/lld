package com.shopping.cart.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Product implements CartItem {

    private Enums.ProductType productType;
    private double price;
    private List<Coupon> appliedCoupons;

    public Product(String productType, double price) {
        this.appliedCoupons = new ArrayList<>();
        this.productType = Enums.ProductType.valueOf(productType);
        this.price = price;
    }

    public void applyCoupon(Coupon coupon) {
        appliedCoupons.add(coupon);
    }

    public double getDiscountedPrice() {
        if (appliedCoupons.isEmpty()) {
            return this.price;
        }
        Double finalPrice = price;

        for (Coupon coupon : appliedCoupons) {
            if (coupon.isDeductionType() == Enums.DeductionType.PERCENTAGE) {
                finalPrice = finalPrice * (100 - coupon.getDiscount()) /100;
            } else {
                finalPrice =  finalPrice - coupon.getDiscount();
            }
        }
        return finalPrice;
    }

    @Override
    public boolean isCoupon() {
        return false;
    }
}
