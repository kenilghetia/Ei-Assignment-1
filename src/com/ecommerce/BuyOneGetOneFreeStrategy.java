package com.ecommerce;

// BuyOneGetOneFreeStrategy class
class BuyOneGetOneFreeStrategy implements DiscountStrategy {
    @Override
    public double applyDiscount(double price, int quantity) {
        try {
            int freeItems = quantity / 2; // Calculate the number of free items (every 2nd item is free)
            return price * (quantity - freeItems); // Calculate the discounted price by subtracting the price of free items
        } catch (ArithmeticException e) {
            System.err.println("Arithmetic exception: " + e.getMessage()); // Handle any potential arithmetic exceptions (unlikely in this case)
            return price * quantity; // Return the original price if an exception occurs
        }
    }
}
