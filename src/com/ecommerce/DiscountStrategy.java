package com.ecommerce;

// DiscountStrategy interface
interface DiscountStrategy {
    double applyDiscount(double price, int quantity);
}
