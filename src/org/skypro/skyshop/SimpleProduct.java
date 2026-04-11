package org.skypro.skyshop;

public class SimpleProduct extends Product {
    private final int price;

    public SimpleProduct(String name, int price, int price1) {
        super(name, price);
        this.price = price1;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "SimpleProduct{" + getName() + ":" + "price=" + price +'}';
    }
}
