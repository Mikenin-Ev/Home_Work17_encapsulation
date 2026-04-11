package org.skypro.skyshop;

public class Product {
    private final String name;
    private final int price;

    public Product(String name, int price) {
        if (price < 0) {
            System.out.println("Цена товара не может быть отрицательной...");
        }
        else if (price == 0){
            System.out.println("Ничего не бывает даром...");
        }
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "<" + name + ">" + ":" + "<" + price + ">";
    }
}
