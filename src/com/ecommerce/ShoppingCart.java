package com.ecommerce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// ShoppingCart class
class ShoppingCart {
    private static ShoppingCart instance; // Step 1: Create a private static instance of the class
    private Map<String, CartItem> cartItems = new HashMap<>();

    private ShoppingCart() {} // Step 2: Create a private constructor to prevent external instantiation

    // Step 3: Create a public static method to get the single instance
    public static ShoppingCart getInstance() {
        if (instance == null) {
            instance = new ShoppingCart();
        }
        return instance;
    }

    public Map<String, CartItem> getCartItems() {
        return cartItems;
    }

    public void addItem(Product product, int quantity) {
        try {
            if (!product.isAvailable()) {
                throw new IllegalArgumentException("Product is not available.");
            }

            String productName = product.getName();
            CartItem cartItem = cartItems.get(productName);

            if (cartItem != null) {
                cartItem = new CartItem(product, cartItem.getQuantity() + quantity);
            } else {
                cartItem = new CartItem(product, quantity);
            }

            cartItems.put(productName, cartItem);
            System.out.println(quantity + " " + productName + " added to your cart.");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    public void updateItemQuantity(String productName, int quantity) {
        try {
            CartItem cartItem = cartItems.get(productName);

            if (cartItem == null) {
                throw new IllegalArgumentException("Product not found in your cart.");
            }

            cartItem = new CartItem(cartItem.getProduct(), quantity);
            cartItems.put(productName, cartItem);
            System.out.println("Cart item updated successfully.");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    public void removeItem(String productName) {
        try {
            CartItem cartItem = cartItems.remove(productName);

            if (cartItem == null) {
                throw new IllegalArgumentException("Product not found in your cart.");
            }

            System.out.println(productName + " removed from your cart.");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    public void displayCartItems() {
        List<String> itemDescriptions = new ArrayList<>();

        for (CartItem cartItem : cartItems.values()) {
            String productName = cartItem.getProduct().getName();
            int quantity = cartItem.getQuantity();
            itemDescriptions.add(quantity + " " + productName);
        }

        String cartItemsText = String.join(" and ", itemDescriptions);
        System.out.println("You have " + cartItemsText + " in your cart.");
    }

    public double calculateTotalBill() {
        double total = 0.0;

        for (CartItem cartItem : cartItems.values()) {
            Product product = cartItem.getProduct();
            int quantity = cartItem.getQuantity();
            total += product.applyDiscount(quantity);
        }

        return total;
    }

    public void displayTotalBill() {
        try {
            double total = calculateTotalBill();
            System.out.println("Your total bill is $" + total + ".");
        } catch (Exception e) {
            System.err.println("An error occurred while calculating the total bill: " + e.getMessage());
        }
    }
}
