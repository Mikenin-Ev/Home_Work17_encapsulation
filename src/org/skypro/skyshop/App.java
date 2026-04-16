package org.skypro.skyshop;

import org.skypro.skyshop.Basket.ProductBasket;
import org.skypro.skyshop.Product.DiscountedProduct;
import org.skypro.skyshop.Product.FixPrice;
import org.skypro.skyshop.Product.Product;
import org.skypro.skyshop.Product.SimpleProduct;

public class App {
    public static void main(String[] args){
        Product p1 = new SimpleProduct("Хлеб", 50);
        Product p2 = new FixPrice("Кефир");
        Product p3 = new SimpleProduct("Мясо", 350);
        Product p4 = new FixPrice("Сыр");
        Product p5 = new DiscountedProduct("Яблоки", 105, 20);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
        System.out.println(p5);

       ProductBasket basket = new ProductBasket();

        basket.addProduct(p2);
        basket.addProduct(p5);
        basket.addProduct(p4);
        basket.addProduct(p1);
        basket.addProduct(p3);
        basket.addProduct(p2);

        basket.printContents();

        int totalCost = basket.getTotalCost();
        System.out.println("Общая стоимость корзины: " + totalCost + " руб.\n");

        boolean isFound = basket.findProduct("Хлеб");
        if (isFound) {
            System.out.println("Товар 'Хлеб' найден.");
        } else {
            System.out.println("Товар 'Хлеб' не найден.");
        }

        isFound = basket.findProduct("Мясо");
        if (isFound) {
            System.out.println("Товар 'Мясо' найден.");
        } else {
            System.out.println("Товар 'Мясо' не найден.\n");
        }

        basket.clear();

        basket.printContents();

        totalCost = basket.getTotalCost();
        System.out.println("Стоимость пустой корзины: " + totalCost + " руб.\n");

        isFound = basket.findProduct("Яблоки");
        if (isFound) {
            System.out.println("В пустой корзине товар 'Яблоки' не найден." );
        } else {
            System.out.println("В пустой корзине товар 'Яблоки' не найден.");
        }
    }
}
