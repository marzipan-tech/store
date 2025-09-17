package org.skypro.skyshop.product;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {
    private String name;

    public Product(String name) throws IllegalArgumentException {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Название не может быть пустым");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();

    public boolean isSpecial() {
        return false;
    }

    @Override
    public String searchTerm() {
        return name;
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }
}
