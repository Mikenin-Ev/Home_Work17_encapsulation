package org.skypro.skyshop.Basket;

import org.skypro.skyshop.Product.Product;

import java.util.*;

public class ProductBasket {
    private final List<Product> products = new LinkedList<>();

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Нельзя добавить null");
        }
        products.add(product);
    }

    public int getTotalCost() {
        int total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    public void printBasket() {
        System.out.println("\n--- Содержимое корзины ---");
        if (products.isEmpty()) {
            System.out.println("Корзина пуста...");
        } else {
            int count = 0;
            for (Product product : products) {
                System.out.println(product);
                if (product.isSpecial()) {
                    count++;
                }
            }
            System.out.printf("Итого: %d%n", getTotalCost());
            System.out.printf("Специальных товаров: %d%n", count);
        }
        System.out.println("--------------------------\n");
    }

    public List<Product> removeByName(String name) {
        List<Product> removed = new LinkedList<>();
        Iterator<Product> iter = products.iterator();
        while (iter.hasNext()) {
            Product next = iter.next();
            if (next.getName().equals(name)) {
                iter.remove();
                removed.add(next);
            }
        }
        return removed;
    }

    public boolean findProduct(String name) {
    for (Product product : products) {
        if (product.getName().equals(name)) {
            return true;
        }
    }
    return false;
    }


    public void clearBasket() {
        this.products.clear();
        System.out.println("Корзина очищена.");
    }
}