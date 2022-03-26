package com.shopping.cart.model;

public class Application {

    public static void main(String[] args) {

        Cart cart = new ShoppingCart();
        cart.addItem(new Product("WALLET", 10));
        cart.addItem(new CouponNTH(2, Enums.ProductType.WALLET, 2));
        cart.addItem(new CouponALL(25));
        cart.addItem(new CouponNext(10));
        cart.addItem(new Product("WALLET", 10));
        double finalPrice = cart.checkout();
        System.out.println(finalPrice);

    }
}
