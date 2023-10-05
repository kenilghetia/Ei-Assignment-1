package com.ecommerce;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Create a list of products
        List<Product> products = new ArrayList<>();

        products.add(new ElectronicsProduct("Laptop", 1000, true, "Apple", new PercentageDiscountStrategy(18)));
        products.add(new ElectronicsProduct("Smartphone", 500, true, "Motorola", new PercentageDiscountStrategy(5)));
        products.add(new ElectronicsProduct("Monitor", 200, true, "HP", new PercentageDiscountStrategy(12)));
        products.add(new ElectronicsProduct("Mouse", 15, true, "HP", new PercentageDiscountStrategy(8)));
        products.add(new ElectronicsProduct("Chair", 100, true, "XYZ", new PercentageDiscountStrategy(15)));
        products.add(new ElectronicsProduct("Headphones", 50, true, "boAt", new BuyOneGetOneFreeStrategy()));
        products.add(new ElectronicsProduct("Tablet", 300, true, "Samsung", new BuyOneGetOneFreeStrategy()));
        products.add(new ElectronicsProduct("Keyboard", 30, true, "HP", new BuyOneGetOneFreeStrategy()));
        products.add(new ElectronicsProduct("Printer", 150, true, "HP", new BuyOneGetOneFreeStrategy()));
        products.add(new ElectronicsProduct("Desk", 250, true, "XYZ", new BuyOneGetOneFreeStrategy()));


        // Initialize the shopping cart
        ShoppingCart cart = ShoppingCart.getInstance();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Options:");
                System.out.println("1. Add Product to Cart");
                System.out.println("2. Remove Product from Cart");
                System.out.println("3. Display Cart Items");
                System.out.println("4. Display Total Bill");
                System.out.println("5. Create Invoice");
                System.out.println("6. Update Quantity of Product in Cart");
                System.out.println("7. Exit");
                System.out.print("Enter option: ");

                int option = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (option) {
                    case 1:
                        System.out.println("Available Products:");
                        for (Product product : products) {
                            String discountStrategy = product.getDiscountStrategy() instanceof BuyOneGetOneFreeStrategy ?
                                    "Buy One Get One Free Offer" : "Percentage Off (T&C applied)";
                            System.out.println(product.getName() + " - Price: $" + product.getPrice() + " - Available: " + product.isAvailable() +
                                    " - Discount Strategy: " + discountStrategy);
                        }

                        System.out.print("Enter product name: ");
                        String productName = scanner.nextLine();
                        System.out.print("Enter quantity: ");
                        int quantity = scanner.nextInt();
                        scanner.nextLine();
                        Product selectedProduct = products.stream()
                                .filter(p -> p.getName().equalsIgnoreCase(productName))
                                .findFirst()
                                .orElse(null);

                        if (selectedProduct != null) {
                            if (selectedProduct.getDiscountStrategy() instanceof BuyOneGetOneFreeStrategy) {
                                // Apply BOGO offer
                                int numberOfItemsToAdd = quantity * 2; // Double the quantity for BOGO
                                cart.addItem(selectedProduct, numberOfItemsToAdd);
                            } else {
                                cart.addItem(selectedProduct, quantity);
                            }
                        } else {
                            System.out.println("Product not found.");
                        }
                        break;
                    case 2:
                        cart.displayCartItems();
                        System.out.print("Enter product name to remove: ");
                        String productToRemove = scanner.nextLine();
                        cart.removeItem(productToRemove);
                        break;
                    case 3:
                        cart.displayCartItems();
                        break;
                    case 4:
                        cart.displayCartItems();
                        cart.displayTotalBill();
                        break;
                    case 5:
                        cart.displayCartItems();
                        cart.displayTotalBill();
                        generateInvoice(cart);
                        break;
                    case 6:
                        cart.displayCartItems();
                        System.out.print("Enter product name to update quantity: ");
                        String productToUpdate = scanner.nextLine();
                        System.out.print("Enter new quantity: ");
                        int newQuantity = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        cart.updateItemQuantity(productToUpdate, newQuantity);
                        break;
                    case 7:
                        System.out.println("Exiting...");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid option. Try again.");
                }
            } catch (InputMismatchException e) {
                // Handle input mismatch exceptions (e.g., non-integer input)
                System.err.println("Invalid input. Please enter a valid option.");
                scanner.nextLine(); // Consume invalid input to prevent infinite loop
            }
        }
    }

    private static void generateInvoice(ShoppingCart cart) {
        // Generate an invoice with cart details
        System.out.println("\n--- Invoice ---");
        for (CartItem cartItem : cart.getCartItems().values()) {
            Product product = cartItem.getProduct();
            int quantity = cartItem.getQuantity();
            double originalPrice = product.getPrice() * quantity;
            double discountedPrice = product.applyDiscount(quantity);
            System.out.println(product.getName() + " - Quantity: " + quantity +
                    " - Original Price: $" + originalPrice + " - Discounted Price: $" + discountedPrice);
        }
        System.out.println("Total Bill: $" + cart.calculateTotalBill());
        System.out.println("--- End of Invoice ---\n");
    }
}
