package org.skypro.skyshop;

import org.skypro.skyshop.Basket.ProductBasket;
import org.skypro.skyshop.Info.Article;
import org.skypro.skyshop.Product.DiscountedProduct;
import org.skypro.skyshop.Product.FixPrice;
import org.skypro.skyshop.Product.Product;
import org.skypro.skyshop.Product.SimpleProduct;
import org.skypro.skyshop.Search.SearchEngine;

import java.util.Arrays;

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

        SearchEngine searchEngine = new SearchEngine();
        searchEngine.addAll(p1, p2, p3, p4, p5);

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
                "Наслаждение в трёх вещах: есть мясо, ездить верхом на мясе и..."
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
    }
}
