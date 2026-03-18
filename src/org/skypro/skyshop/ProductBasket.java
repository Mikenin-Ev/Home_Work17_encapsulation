package org.skypro.skyshop;

import java.util.ArrayList;
import java.util.List;

public class ProductBasket {
    private static final int MAX_UNITS = 3;
    private List<Product> units = new ArrayList<>();

    public boolean addProduct(Product product) {
        if (units.size() >= MAX_UNITS) {
            System.out.println("Ошибка: Корзина заполнена! Нельзя добавить '" + product.getName() + "'.");
            return false;
        }
        units.add(product);
        System.out.println("Успешно добавлен: " + product.getName());
        return true;
    }

    public void printContents() {
        System.out.println("\n--- Содержимое корзины ---");
        if (units.isEmpty()) {
            System.out.println("Корзина пуста.");
        } else {
            for (int i = 0; i < units.size(); i++) {
                System.out.println((i + 1) + ". " + units.get(i));
            }
        }
        System.out.println("-------------------------\n");
    }
    public int getTotalCost() {
        int total = 0;
        for (Product unit : units) {
            total += unit.getPrice();
        }
        return total;
    }

    public Product findProduct(String name) {
        for (Product unit : units) {
            if (unit.getName().equalsIgnoreCase(name)) {
                return unit;
            }
        }
        return null;
    }

    public void clear() {
        units.clear();
        System.out.println("Корзина очищена.");
    }
}
