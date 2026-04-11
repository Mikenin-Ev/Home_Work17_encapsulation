package org.skypro.skyshop;

public class App {
    public static void main(String[] args){
        SimpleProduct sp1 = new SimpleProduct("Хлеб", 50);
        SimpleProduct sp2 = new SimpleProduct("Кефир", 120);
        SimpleProduct sp3 = new SimpleProduct("Мясо", 350);
        SimpleProduct sp4 = new SimpleProduct("Сыр", 1050);
        SimpleProduct sp5 = new SimpleProduct("Яблоки", 105);

        System.out.println(sp1);
        System.out.println(sp2);
        System.out.println(sp3);
        System.out.println(sp4);
        System.out.println(sp5);

       ProductBasket basket = new ProductBasket();

        basket.addProduct(sp2);
        basket.addProduct(sp5);
        basket.addProduct(sp4);
        basket.addProduct(sp1);
        basket.addProduct(sp3);
        basket.addProduct(sp2);

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
