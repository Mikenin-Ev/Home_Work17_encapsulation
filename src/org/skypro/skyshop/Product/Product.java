package org.skypro.skyshop.Product;

import org.skypro.skyshop.Search.Searchable;

public abstract class Product implements Searchable {
    private final String name;

    public Product(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Название продукта не может быть пустым или состоять только из пробелов");
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public String getSearchTerm() {
        return name;
    }

    @Override
    public String getSearchContentType() {
        return "PRODUCT";
    }
}
