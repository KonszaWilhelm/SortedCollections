package com.wilhelm.konsza;

public class Main {

    private static StockList stockList = new StockList();

    public static void main(String[] args) {


        StockItem temp = new StockItem("bread", 0.86, 100);
        stockList.addStockItem(temp);

        temp = new StockItem("cake", 1.10, 7);
        stockList.addStockItem(temp);

        temp = new StockItem("cake", 1.10, 7);
        stockList.addStockItem(temp);

        temp = new StockItem("car", 2.50, 2);
        stockList.addStockItem(temp);

        temp = new StockItem("chair", 62.10, 10);
        stockList.addStockItem(temp);

        temp = new StockItem("cup", 0.50, 7);
        stockList.addStockItem(temp);

        temp = new StockItem("cup", 0.50, 7);
        stockList.addStockItem(temp);

        temp = new StockItem("door", 71.10, 7);
        stockList.addStockItem(temp);

        temp = new StockItem("juice", 8.99, 15);
        stockList.addStockItem(temp);

        temp = new StockItem("phone", 110.99, 25);
        stockList.addStockItem(temp);


        System.out.println(stockList);


        Cart myCart = new Cart("Vili");
        addToCart(myCart, "car", 1);
        System.out.println(myCart);

        addToCart(myCart, "car", 1);
        System.out.println(myCart);

        addToCart(myCart, "car", 1);
        System.out.println(myCart);

        System.out.println(stockList);
        System.out.println("Price list: " + stockList.getPriceList());

    }

    public static int sellItem(Cart cart, String itemName, int quantity) {
        StockItem stockItem = stockList.getStockItem(itemName);
        if (stockItem == null)
            return 0;
        if (stockList.sellStockItem(itemName, quantity) != 0) {
            cart.addToShoppingCart(stockItem, quantity);
            return quantity;
        }
        return 0;
    }


    public static int addToCart(Cart cart, String itemName, int reservedQuantity) {
        StockItem stockItem = stockList.getStockItem(itemName);
        if (stockItem == null)
            return 0;
        if (stockList.reserveStockItem(itemName, reservedQuantity)) {
            cart.addToShoppingCart(stockItem, reservedQuantity);
            return reservedQuantity;
        }
        return 0;
    }

}
