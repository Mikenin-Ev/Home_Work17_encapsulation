package org.skypro.skyshop.Product;

public class DiscountedProduct extends Product {
    private int basePrice;
    private int discount;

    public DiscountedProduct(String title, int basePrice, int discount) {
        super(title);
        this.basePrice = basePrice;
        this.discount = discount;
    }

    @Override
    public int getPrice() {
        return basePrice - (int)(basePrice * discount * 0.01);
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getTitle() + ": " + getPrice() + " (" + discount + "%)";
    }
}