package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        Product bread = new Product("Хлеб", 100);
        Product milk = new Product("Молоко", 120);
        Product cheese = new Product("Сыр", 140);
        Product butter = new Product("Масло", 430);
        Product rice = new Product("Рис", 150);

        ProductBasket basket = new ProductBasket();
        basket.addProduct(bread);
        basket.addProduct(milk);
        basket.addProduct(cheese);
        basket.addProduct(butter);
        basket.addProduct(rice);
        basket.addProduct(milk);
        basket.printBasket();
        System.out.println(basket.findTotalSum());
        System.out.println(basket.checkIsProductInBasket("Рис"));
        System.out.println(basket.checkIsProductInBasket("Конфеты"));
        basket.emptyBasket();
        basket.printBasket();
        System.out.println(basket.findTotalSum());
        System.out.println(basket.checkIsProductInBasket("Рис"));
    }
}
