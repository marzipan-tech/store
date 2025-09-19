package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private LinkedList<Product> products;

    public ProductBasket() {
        this.products = new LinkedList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public int findTotalSum() {
        int totalSum = 0;
        for (Product product : products) {
            if (product != null) {
                totalSum += product.getPrice();
            }
        }
        return totalSum;
    }

    private int countSpecialProducts() {
        int count = 0;
        for (Product product : products) {
            if (product != null && product.isSpecial()) {
                count++;
            }
        }
        return count;
    }

    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
        }
        for (Product product : products) {
            if (product != null) {
                System.out.println(product);
            }
        }
        System.out.println("Итого: " + findTotalSum() + " руб.");
        System.out.println("Специальных товаров: " + countSpecialProducts());
    }

    public boolean checkIsProductInBasket(String name) {
        for (Product product : products) {
            if (product != null && Objects.equals(product.getName(), name)) {
                return true;
            }
        }
        return false;
    }

    public void emptyBasket() {
        products.clear();
    }

    public List<Product> deleteProductByName(String name) {
        Iterator<Product> iterator = products.iterator();
        List<Product> deletedItems = new ArrayList<>();
        while (iterator.hasNext()) {
            Product item = iterator.next();
            if (item.searchTerm().equalsIgnoreCase(name)) {
                deletedItems.add(item);
                iterator.remove();
            }
        }
        return deletedItems;
    }
}
