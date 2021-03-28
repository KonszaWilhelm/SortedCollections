package com.wilhelm.konsza;

import java.util.*;

public class StockList {
    private final Map<String, StockItem> stockList;

    public StockList() {
        this.stockList = new HashMap<>();
    }

    public int addStockItem(StockItem item) {
        if (item != null) {
            StockItem stockItem = stockList.getOrDefault(item.getName(), item);
            if (stockItem != item)
                stockItem.setQuantity(item.getQuantity());
            stockList.put(stockItem.getName(), stockItem);
            return item.getQuantity();
        }
        return 0;
    }

    public int sellStockItem(String itemName, int quantity) {
        if (stockList.containsKey(itemName))
            if (stockList.get(itemName).getQuantity() >= quantity && quantity > 0) {
                stockList.get(itemName).setQuantity(-quantity);
                System.err.println("In sell stock item");
                return quantity;
            } else
                System.err.println("Out of stock or non existent item: " + itemName);
        return 0;
    }

    public StockItem getStockItem(String itemName) {
        return stockList.get(itemName);
    }

    public Map<String, Double> getPriceList() {
        Map<String, Double> prices = new LinkedHashMap<>();
        for (Map.Entry<String, StockItem> itemEntry : stockList.entrySet()
        ) {
            prices.put(itemEntry.getKey(), itemEntry.getValue().getPrice());
        }
        return Collections.unmodifiableMap(prices);
    }

    public boolean reserveStockItem(String itemName, int quantityToReserve) {
        if (stockList.containsKey(itemName))
            if (stockList.get(itemName).getQuantity() >= quantityToReserve && quantityToReserve > 0) {
                stockList.get(itemName).setReservedQuantity(quantityToReserve);
                stockList.get(itemName).setQuantity(-quantityToReserve);
                return true;
            } else {
                System.err.println("Not enough quantity in stock!");
            }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, StockItem> item : stockList.entrySet())
            sb.append(item.getValue() + " ");
        return sb.toString();
    }

    public Map<String, StockItem> getStockList() {
        return Collections.unmodifiableMap(stockList);
    }

//    @Override
//    public String toString() {
//        return "StockList{" +
//                "stockList=" + stockList +
//                '}';
//    }
}
