package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;
import java.util.Objects;

public class ProductBasket {
    private Product[] products;

    public ProductBasket() {
        this.products = new Product[5];
    }

    private boolean checkIfBasketFull() {
        boolean basketIsFull = true;
        for (Product product : products) {
            if (product == null) {
                basketIsFull = false;
                break;
            }
        }
        return basketIsFull;
    }

    private boolean checkIfBasketEmpty() {
        boolean basketIsEmpty = true;
        for (Product product : products) {
            if (product != null) {
                basketIsEmpty = false;
                break;
            }
        }
        return basketIsEmpty;
    }

    public void addProduct(Product product) {
        if (checkIfBasketFull()) {
            System.out.println("Невозможно добавить продукт");
        }
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
                return;
            }
        }
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

    public void printBasket() {
        if (checkIfBasketEmpty()) {
            System.out.println("В корзине пусто");
        }
        for (Product product : products) {
            if (product != null) {
                System.out.println(product.getName() + ": " + product.getPrice() + " руб.");
            }
        }
        System.out.println("Итого: " + findTotalSum() + " руб.");
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
        Arrays.fill(products, null);
    }
}
