package org.skypro.skyshop;

import org.skypro.skyshop.Basket.ProductBasket;
import org.skypro.skyshop.Info.Article;
import org.skypro.skyshop.Product.DiscountedProduct;
import org.skypro.skyshop.Product.FixPrice;
import org.skypro.skyshop.Product.Product;
import org.skypro.skyshop.Product.SimpleProduct;
import org.skypro.skyshop.Search.BestResultNotFound;
import org.skypro.skyshop.Search.SearchEngine;
import org.skypro.skyshop.Search.Searchable;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args){

        System.out.println("\n--- Создание продуктов с неправильными данными ---");

        try {
            Product p1 = new SimpleProduct("", 100);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            Product p2 = new SimpleProduct("   ", 100);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            Product p3 = new SimpleProduct("Товар 1", -50);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            Product p4 = new DiscountedProduct("Товар со скидкой", 100, 150);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        Product p5 = new SimpleProduct("Хлеб", 50);
        Product p6 = new FixPrice("Кефир");
        Product p7 = new SimpleProduct("Мясо", 350);
        Product p8 = new FixPrice("Сыр");
        Product p9 = new DiscountedProduct("Яблоки", 105, 20);

        System.out.println(p5);
        System.out.println(p6);
        System.out.println(p7);
        System.out.println(p8);
        System.out.println(p9);

       ProductBasket basket = new ProductBasket();

        basket.addProduct(p6);
        basket.addProduct(p9);
        basket.addProduct(p8);
        basket.addProduct(p5);
        basket.addProduct(p7);
        basket.addProduct(p6);

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

        SearchEngine searchEngine = new SearchEngine();
        searchEngine.addAll(p5, p6, p7, p8, p9);

        Article p1Article = new Article(
                "Хлеб всему голова",
                "Хлеб - это пищевой продукт, выпекаемый из муки. Также словом «хлеб» часто " +
                        "называют сельскохозяйственные культуры, а также зерно этих культур и муку, " +
                        "используемую для выпечки. \n"
        );

        Article p2Article = new Article(
                "Кефир",
                "Внук у бабушки спросил: — Хорошо ли пить кефир? Бабушка сказала честно: — Пить кефир — весьма полезно!\n" +
                        "Чем полезен сей продукт, Почему кефир нам друг? Собираясь в магазин, — Не забудьте про кефир!\n" +
                        "Кефир — жажду утоляет, Калий, кальций восполняет. Витаминов — в нём не счесть, Он содержит даже медь!\n" +
                        "Фосфор, серу, натрий, хром — Минералов в нём набор.\n" +
                        "Так что, взрослые и дети, Вы кефир — на радость, пейте!"
        );

        Article p3Article = new Article(
                "Наслаждение мясом",
                "Наслаждение в трёх вещах: есть мясо, ездить верхом на мясе и... "
        );

        searchEngine.addAll(p1Article, p2Article, p3Article);

        String searchQuery1 = "Хлеб";
        System.out.println("Поиск \"" + searchQuery1 + "\" : " + Arrays.toString(searchEngine.search(searchQuery1)));

        String searchQuery2 = "Кефир";
        System.out.println("Поиск \"" + searchQuery2 + "\" : " + Arrays.toString(searchEngine.search(searchQuery2)));

        String searchQuery3 = "Мясо";
        System.out.println("Поиск \"" + searchQuery3 + "\" : " + Arrays.toString(searchEngine.search(searchQuery3)));

        String searchQuery4 = "Мороженное";
        System.out.println("Поиск \"" + searchQuery4 + "\" : " + Arrays.toString(searchEngine.search(searchQuery4)));

        List<Searchable> products = Arrays.asList(p5, p6, p7, p8, p9);

        System.out.println("Созданные продукты:");
        // Используем for-each для перебора и вывода каждого продукта
        for (Searchable product : products) {
            System.out.println(product);
        }

        // Демонстрация поиска
        System.out.println("\n=== ДЕМОНСТРАЦИЯ ПОИСКА ===");

        // Сценарий 1: успешный поиск
        System.out.println("\n--- Сценарий 1: успешный поиск ---");
        try {
            Searchable result = searchEngine.findBestMatch("Яблоки", products);
            System.out.println("Найден наиболее подходящий объект: " + result);
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка поиска: " + e.getMessage());
        }

        // Сценарий 2: поиск с ошибкой (не найдено)
        System.out.println("\n--- Сценарий 2: поиск без результатов ---");
        try {
            Searchable result = searchEngine.findBestMatch("Апельсин", products);
            System.out.println("Найден наиболее подходящий объект: " + result);
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка поиска: " + e.getMessage());
        }
    }
}
