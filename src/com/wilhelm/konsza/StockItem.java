package com.wilhelm.konsza;


import java.util.Objects;

public class StockItem implements Comparable<StockItem> {
    //reserved field -> stores the number of items reserved -> can't reserve more than available stock
    //available stock is stock count minus reserved amount -> stock count is  reduced when a cart is checked out

    private final String name;
    private double price;
    private int quantity;
    private int reservedQuantity;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantity = 0;
        this.reservedQuantity = 0;
    }

    public StockItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.reservedQuantity = 0;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setPrice(double price) {
        if (price > 0)
            this.price = price;
        else
            System.out.println("Incompatible price");
    }

    public void setQuantity(int quantity) {
        if ((this.quantity + quantity) >= 0)
            this.quantity += quantity;
    }

    public void setReservedQuantity(int quantityToReserve) {
        if (quantity >= quantityToReserve) {
            this.reservedQuantity += quantityToReserve;
        } else
            System.err.println("Not enough quantity in stock!!!!!!!!!!!!!!!!");
    }

    public int getReservedQuantity() {
        return this.reservedQuantity;
    }

    @Override
    public int compareTo(StockItem o) {
        System.out.println("in compare to");
        if (o == this)
            return 0;
        if (o != null)
            return (this.name.compareTo(o.getName()));
        throw new NullPointerException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StockItem))
            return false;
        StockItem stockItem = (StockItem) o;
        return Objects.equals(name, stockItem.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price) + 31;
    }

    @Override
    public String toString() {
        return "\nStockItem{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", reservedQuantity=" + reservedQuantity +
                '}';
    }
}
