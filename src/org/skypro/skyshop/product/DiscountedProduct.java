package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int basePrice;
    private int percentDiscount;

    public DiscountedProduct(String name, int percentDiscount, int basePrice) {
        super(name);
        this.percentDiscount = percentDiscount;
        this.basePrice = basePrice;
    }

    @Override
    public int getPrice() {
        return (int) (basePrice - basePrice / 100.0 * percentDiscount);
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice() + " (" + percentDiscount + "%)";
    }
}
