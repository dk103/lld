package com.shopping.cart.model;


import java.util.List;

public class CouponNTH extends Coupon {

    private Enums.ProductType type;
    private int offset;

    public CouponNTH(double discount, Enums.ProductType type,int offset) {
        super(discount);
        this.type = type;
        this.offset = offset;
    }

    public Enums.ProductType getType() {
        return type;
    }

    public int getOffset() {
        return offset;
    }

    @Override
    protected void process(List<CartItem> items, int currentIndex) {
        int index = 0;
        for (CartItem cartItem : items) {
            if (cartItem.isCoupon()) {
                continue;
            }
            Product product = (Product) cartItem;
            CouponNTH couponNTH = (CouponNTH) this;
            if (product.getProductType() == couponNTH.getType()) {
                index++;
                if (index == couponNTH.getOffset()) {
                    product.applyCoupon(this);
                    break;
                }
            }
        }
    }

    @Override
    public Enums.CouponType getCouponType() {
        return Enums.CouponType.NTH;
    }

    @Override
    public Enums.DeductionType isDeductionType() {
        return Enums.DeductionType.DOLLARS;
    }
}
