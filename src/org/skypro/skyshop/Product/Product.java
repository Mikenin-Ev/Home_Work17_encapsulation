package org.skypro.skyshop.Product;

import org.skypro.skyshop.Search.Searchable;

public abstract class Product implements Searchable {
    private final String name;

    public Product(String title) {
        this.name = title;
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    @Override
    public String toString() {
        return "Product{" +
                "title='" + name + '\'' +
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
