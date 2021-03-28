package com.wilhelm.konsza;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Cart {
    private final String name;
    private final Map<StockItem, Integer> shoppingCartItems;

    public Cart(String name) {
        this.name = name;
        this.shoppingCartItems = new TreeMap<>();
    }

    public int addToShoppingCart(StockItem item, int quantity) {
        if (item != null && quantity > 0) {
            int inBasketQuantity = shoppingCartItems.getOrDefault(item, 0);
            shoppingCartItems.put(item, inBasketQuantity + quantity);
            return inBasketQuantity;
        }
        return 0;
    }

    public Map<StockItem, Integer> getShoppingCartItems() {
        return Collections.unmodifiableMap(shoppingCartItems);
    }


    @Override
    public String toString() {
        return "Cart{" +
                "name='" + name + '\'' +
                ", shoppingCartItems=" + shoppingCartItems +
                '}';
    }
}
