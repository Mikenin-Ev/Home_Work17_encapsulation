package org.skypro.skyshop.Basket;

import org.skypro.skyshop.Product.Product;

public class ProductBasket {
    private static final int MAX_UNITS = 5;
    private Product[] units;
    private int count;

    public ProductBasket() {
        units = new Product[MAX_UNITS];
        count = 0;
    }

    public boolean addProduct(Product product) {
        if (count >= MAX_UNITS) {
            System.out.println("Ошибка: корзина полна! Нельзя добавить '" + product.getName() + "'.");
            return false;
        }
        units[count++] = product;
        System.out.println("Товар '" + product.getName() + "' успешно добавлен в корзину.");
        return true;
    }

    public void printContents() {
        System.out.println("\n--- Содержимое корзины ---");
        if (count == 0) {
            System.out.println("Корзина пуста.");
        } else {
            for (int i = 0; i < count; i++) {
                System.out.println((i + 1) + ". " + units[i]);
            }
        }
        System.out.println("--------------------------\n");
    }

    public int getTotalCost() {
        int total = 0;
        for (int i = 0; i < count; i++) {
            total += units[i].getPrice();
        }
        return total;
    }

public boolean findProduct(String name) {
    for (int i = 0; i < count; i++) {
        if (units[i].getName().equals(name)) {
            return true;
        }
    }
    return false;
}

    public int getSpecialProductCount() {
        int count = 0;
        for (Product product : units) {
            if (product != null) {
                if (product.isSpecial()) {
                    count++;
                }
            }
        }
        return count;
    }

    public void clear() {
        for (int i = 0; i < count; i++) {
           units[i] = null;
        }
        count = 0;
        System.out.println("Корзина очищена.");
    }
}