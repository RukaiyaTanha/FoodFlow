package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private static List<CartItem> items = new ArrayList<>();

    public static void addItem(String name, int price) {
        for (CartItem item : items) {
            if (item.name.equals(name)) {
                item.quantity++;
                return;
            }
        }
        items.add(new CartItem(name, price));
    }

    public static List<CartItem> getItems() {
        return items;
    }

    public static void clear() {
        items.clear();
    }

    public static int getTotal() {
        int total = 0;
        for (CartItem item : items) {
            total += item.quantity * item.price;
        }
        return total;
    }
}
