package org.skypro.skyshop.Basket;

import org.skypro.skyshop.Product.Product;

import java.util.*;

public class ProductBasket {
    private final Map<String, List<Product>> products = new HashMap<>();

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Нельзя добавить null");
        }
        if (products.containsKey(product.getName())) {
            products.get(product.getName()).add(product);
        }

        List<Product> productList;

        if (!products.containsKey(product.getName())) {
            productList = new LinkedList<>();
            products.put(product.getName(), productList);
        } else {
           productList = products.get(product.getName());
        }

        productList.add(product);
    }

    public int getTotalCost() {
        return products.values()
                .stream()
                .flatMap(Collection::stream)
                .mapToInt(Product::getPrice).sum();
    }

    public void printBasket() {
        System.out.println("\n--- Содержимое корзины ---");
        if (products.isEmpty()) {
            System.out.println("Корзина пуста...");
            return;
        } else {
            products.values()
                    .stream()
                    .flatMap(Collection::stream)
                            .forEach(System.out::println);
            System.out.printf("Итого: %d%n", getTotalCost());
            System.out.printf("Специальных товаров: %d%n", getSpecialCount());
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

    private int getSpecialCount() {
        return (int) products.values()
                .stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
    }
}