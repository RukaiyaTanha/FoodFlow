package org.example;

public class CartItem {
    String name;
    int quantity;
    int price;

    public CartItem(String name, int price) {
        this.name = name;
        this.price = price;
        this.quantity = 1;
    }
}
