package org.skypro.skyshop.Product;

public class FixPrice extends Product {
    private final static int PRICE = 300;

    public FixPrice(String name) {
        super(name);
    }

    @Override
    public int getPrice() {
        return PRICE;
    }

    @Override
    public String toString() {
        return getName() + " : Фиксированная цена " + PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}