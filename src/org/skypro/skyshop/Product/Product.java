package org.skypro.skyshop.Product;

import org.skypro.skyshop.Search.Searchable;

public abstract class Product implements Searchable {
    private final String title;

    public Product(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    @Override
    public String toString() {
        return "Product{" +
                "title='" + title + '\'' +
                '}';
    }

    @Override
    public String getSearchTerm() {
        return title
    }

    @Override
    public String getSearchContentTypa() {
        return "PRODUCT";
    }
}
