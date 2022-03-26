package com.shopping.cart.model;


import java.util.List;

public class CouponALL extends Coupon {

    public CouponALL(double discount) {
        super(discount);
    }

    @Override
    public Enums.CouponType getCouponType() {
        return Enums.CouponType.ALL;
    }

    @Override
    protected void process(List<CartItem> items,  int currentIndex) {
        for (CartItem cartItem : items) {
            if (cartItem.isCoupon()) {
                continue;
            }
            Product product = (Product) cartItem;
            product.applyCoupon(this);
        }
    }


    @Override
    public Enums.DeductionType isDeductionType() {
        return Enums.DeductionType.PERCENTAGE;
    }
}
