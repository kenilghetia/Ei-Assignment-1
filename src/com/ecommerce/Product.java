package com.ecommerce;

// Product class with Prototype Pattern
class Product implements Cloneable {
    private String name;
    private double price;
    private boolean available;
    private DiscountStrategy discountStrategy;

    public Product(String name, double price, boolean available, DiscountStrategy discountStrategy) {
        this.name = name;
        this.price = price;
        this.available = available;
        this.discountStrategy = discountStrategy;
    }

    public Product clone() throws CloneNotSupportedException {
        return (Product) super.clone();
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public DiscountStrategy getDiscountStrategy() {
        return discountStrategy;
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public boolean isAvailable() {
        return available;
    }

    public double applyDiscount(int quantity) {
        return discountStrategy.applyDiscount(price, quantity);
    }
}