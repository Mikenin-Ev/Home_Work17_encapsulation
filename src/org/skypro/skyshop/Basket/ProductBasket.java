package org.skypro.skyshop.Basket;

import org.skypro.skyshop.Product.Product;

import java.util.*;

public class ProductBasket {
    private final Map<String, List<Product>> products = new HashMap<>();

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Нельзя добавить null");
        }
//        if (products.containsKey(product.getName())) {
//            products.get(product.getName()).add(product);
//        } else {
//            List<Product> productList = new ArrayList<>();
//            productList.add(product);
//            products.put(product.getName(), productList);
//        }
        products.computeIfAbsent(product.getName(), k -> new LinkedList<>()).add(product);
    }

    public int getTotalCost() {
        int total = 0;
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                total += product.getPrice();
            }
        }
        return total;
    }

    public void printBasket() {
        System.out.println("\n--- Содержимое корзины ---");
        if (products.isEmpty()) {
            System.out.println("Корзина пуста...");
            return;
        } else {
            int count = 0;
            for (List<Product> productList : products.values()) {
                for (Product product : productList) {
                    System.out.println(product);
                    if (product.isSpecial()) {
                        count++;
                    }
                }
            }
            System.out.printf("Итого: %d%n", getTotalCost());
            System.out.printf("Специальных товаров: %d%n", count);
        }
        System.out.println("--------------------------\n");
    }

    public List<Product> removeByName(String name) {
//        return products.remove(name);
        List<Product> removedProducts = products.remove(name);

        if (removedProducts == null) {
            return new LinkedList<>();
        }

        return removedProducts;

    }

    public boolean findProduct(String name) {
        return products.containsKey(name);
    }

    public void clearBasket() {
        this.products.clear();
        System.out.println("Корзина очищена.");
    }
}