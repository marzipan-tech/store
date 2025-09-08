package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        Product bread = new SimpleProduct("Хлеб", 100);
        Product milk = new DiscountedProduct("Молоко", 12, 200);
        Product cheese = new SimpleProduct("Сыр", 140);
        Product butter = new SimpleProduct("Масло", 430);
        Product rice = new SimpleProduct("Рис", 150);
        Product flour = new DiscountedProduct("Мука", 5, 105);
        Product cream = new FixPriceProduct("Сливки");

        ProductBasket basket = new ProductBasket();
        basket.addProduct(bread);
        basket.addProduct(milk);
        basket.addProduct(cream);
        basket.addProduct(butter);
        basket.addProduct(flour);
        basket.addProduct(milk);
        basket.printBasket();
        System.out.println(basket.findTotalSum());
        System.out.println(basket.checkIsProductInBasket("Мука"));
        System.out.println(basket.checkIsProductInBasket("Конфеты"));
        basket.emptyBasket();
        basket.printBasket();
        System.out.println(basket.findTotalSum());
        System.out.println(basket.checkIsProductInBasket("Рис"));
    }
}
