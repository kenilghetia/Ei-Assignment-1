package com.ecommerce;

// PercentageDiscountStrategy
class PercentageDiscountStrategy implements DiscountStrategy {
    private double percentage;

    public PercentageDiscountStrategy(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public double applyDiscount(double price, int quantity) {
        return price * quantity * (1 - percentage / 100);
    }
}