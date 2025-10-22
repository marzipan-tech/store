package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private Map<String, List<Product>> products;

    public ProductBasket() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product product) {
        products.computeIfAbsent(product.getName().toLowerCase(), k -> new LinkedList<>()).add(product);
    }

    public int findTotalSum() {
        return products.values()
                .stream()
                .flatMap(Collection::stream)
                .mapToInt(Product::getPrice)
                .sum();
    }

    private int countSpecialProducts() {
        return Math.toIntExact(products.values()
                .stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count());
    }

    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
        }
        products.values()
                .stream()
                .flatMap(Collection::stream)
                .forEach(System.out::println);
        System.out.println("Итого: " + findTotalSum() + " руб.");
        System.out.println("Специальных товаров: " + countSpecialProducts());
    }

    public boolean checkIsProductInBasket(String name) {
        return products.values()
                .stream()
                .flatMap(Collection::stream)
                .anyMatch(i -> Objects.equals(i.getName(), name));
    }

    public void emptyBasket() {
        products.clear();
    }

    public List<Product> deleteProductByName(String name) {
        return products.remove(name.toLowerCase());
    }
}
