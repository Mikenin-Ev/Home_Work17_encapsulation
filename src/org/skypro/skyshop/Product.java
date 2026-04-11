package org.skypro.skyshop;

public abstract class Product {
    private final String name;

    public Product(String name, int price) {
        if (price < 0) {
            System.out.println("Цена товара не может быть отрицательной...");
        }
        else if (price == 0){
            System.out.println("Ничего не бывает даром...");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();

    @Override
    public String toString() {
        return name;
    }
}
