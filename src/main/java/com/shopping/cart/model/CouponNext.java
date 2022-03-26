package com.shopping.cart.model;

import java.util.Collection;
import java.util.List;

public class CouponNext extends Coupon {

    public CouponNext(double discount) {
        super(discount);
    }

    @Override
    protected void process(List<CartItem> items,  int currentIndex) {
        for (int i = currentIndex + 1; i < items.size(); i++) {
            if (!items.get(i).isCoupon()) {
                Product lineItem = (Product) items.get(i);
                lineItem.applyCoupon(this);
            }
        }
    }

    @Override
    public Enums.CouponType getCouponType() {
        return Enums.CouponType.NEXT;
    }


    @Override
    public Enums.DeductionType isDeductionType() {
        return Enums.DeductionType.PERCENTAGE;
    }
}
