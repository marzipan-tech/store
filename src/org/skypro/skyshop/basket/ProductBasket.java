package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private Map<String, List<Product>> products;

    public ProductBasket() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product product) {
        products.computeIfAbsent(product.getName(), k -> new LinkedList<>()).add(product);
    }

    public int findTotalSum() {
        int totalSum = 0;
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                if (product != null) {
                    totalSum += product.getPrice();
                }
            }
        }
        return totalSum;
    }

    private int countSpecialProducts() {
        int count = 0;
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                if (product != null && product.isSpecial()) {
                    count++;
                }
            }
        }
        return count;
    }

    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
        }
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                if (product != null) {
                    System.out.println(product);
                }
            }
        }
        System.out.println("Итого: " + findTotalSum() + " руб.");
        System.out.println("Специальных товаров: " + countSpecialProducts());
    }

    public boolean checkIsProductInBasket(String name) {
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                if (product != null && Objects.equals(product.getName(), name)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void emptyBasket() {
        products.clear();
    }

    public List<Product> deleteProductByName(String name) {
        List<Product> deletedItems = new ArrayList<>();
        for (List<Product> productList : products.values()) {
            Iterator<Product> iterator = productList.iterator();
            while (iterator.hasNext()) {
                Product item = iterator.next();
                if (item.searchTerm().equalsIgnoreCase(name)) {
                    deletedItems.add(item);
                    iterator.remove();
                }
            }
        }
        return deletedItems;
    }
}
