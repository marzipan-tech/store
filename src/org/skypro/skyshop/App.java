package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.SearchEngine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) throws BestResultNotFound {
        Product bread = new SimpleProduct("Хлеб", 100);
        Product milk = new DiscountedProduct("Молоко", 12, 200);
        Product cheese = new SimpleProduct("Сыр", 140);
        Product butter = new SimpleProduct("Масло", 430);
        Product biscuit = new SimpleProduct("Печенье", 230);
        Product rice = new SimpleProduct("Рис", 150);
        Product flour = new DiscountedProduct("Мука", 5, 105);
        Product cream = new FixPriceProduct("Сливки");
        Product potato = new DiscountedProduct("Картофель", 100, 90);
        Product tomato = new DiscountedProduct("Помидоры", 0, 150);

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
        basket.addProduct(tomato);
        basket.addProduct(potato);
        basket.printBasket();
        System.out.println(basket.findTotalSum());
        System.out.println(basket.checkIsProductInBasket("Рис"));
        SearchEngine engine = new SearchEngine(15);
        engine.add(bread);
        engine.add(flour);
        engine.add(milk);
        engine.add(butter);
        engine.add(cream);
        engine.add(cheese);
        engine.add(rice);
        engine.add(biscuit);
        Article breadBorodinskiyKolomenskoe = new Article("Бородинский хлеб", "БКХ «Коломенское». В нарезке.");
        Article breadRzhanoyKolomenskoe = new Article("Ржаной хлеб", "БКХ «Коломенское». В нарезке.");
        Article milkProstokvashino32 = new Article("Молоко, 3,2%", "«Простоквашино». Пастеризованное");
        Article milkZdravushka20 = new Article("Молоко, 2,0%", "«Здравушка». Пастеризованное");
        Article creamVkusnoteevo33 = new Article("Сливки, 33%", "«Вкуснотеево». Для взбивания");
        engine.add(milkZdravushka20);
        engine.add(creamVkusnoteevo33);
        engine.add(breadBorodinskiyKolomenskoe);
        engine.add(milkProstokvashino32);
        engine.add(breadRzhanoyKolomenskoe);
        System.out.println(engine.search("мясо").values());
        System.out.println(engine.search("вкуснотеево").values());
        System.out.println(engine.search("хлеб").values());
        try {
            Product fish = new DiscountedProduct(" ", 10, 1200);
            Product salt = new FixPriceProduct("");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            Product cherry = new SimpleProduct("Вишня", -310);
            Product banana = new DiscountedProduct("Бананы", 10, -120);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            Product apple = new DiscountedProduct("Яблоки", 120, 105);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            Product fish = new DiscountedProduct(" ", 10, 1200);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            Product banana = new DiscountedProduct("Бананы", 10, -120);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(engine.findMostRelevant("хлеб"));
        System.out.println(engine.findMostRelevant("молоко"));
        System.out.println(engine.findMostRelevant("о"));
        try {
            engine.findMostRelevant("блин");
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }
        basket.addProduct(milk);
        basket.addProduct(cheese);
        basket.addProduct(bread);
        basket.addProduct(flour);
        System.out.println(basket.deleteProductByName("сыр"));
        basket.printBasket();
        List<Product> deletedItems = basket.deleteProductByName("яблоки");
        if (deletedItems == null) {
            System.out.println("Список пуст");
        } else {
            System.out.println(deletedItems);
        }
        basket.printBasket();
    }
}
