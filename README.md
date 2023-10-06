# Ei-Assignments

I have implemented two problem statements in **Java**.  
- **Ecommerce Cart System** - [Repository Link 1](https://github.com/kenilghetia/Ei-Assignment-1) *(This Repository)*  
- **Satellite Command System** - [Repository Link 2](https://github.com/kenilghetia/Ei-Assignment-2)  

---

# E-Commerce Cart System

## Introduction
This codebase represents a simple E-commerce cart system. The system allows users to interact with products, add them to a shopping cart, code apply various discount strategies, calculate the total bill and generate invoices. The codebase uses Java and follows Object-Oriented Programming (OOP) principles.

## Table of Contents

- [Project Folder Structure](#project-folder-structure)
- [Functionalities](#functionalities)
- [Features](#features)
  - [Use of Design Patterns in code](#use-of-design-patterns-in-code)
  - [Use of OOP principles in code](#use-of-oop-principles-in-code)
  - [Use of SOLID Principles in code](#use-of-solid-principles-in-code)
- [Usage](#usage)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)


## Project Folder Structure

    ├── src (Source code directory)
    │ └── com
    │   └── ecommerce
    │        ├── ShoppingCart.java (Class for managing the shopping cart)
    │        ├── Product.java (Class representing products)
    │        ├── DiscountStrategy.java (Interface for discount strategies)
    │        ├── PercentageDiscountStrategy.java (Class implementing percentage-based discounts)
    │        ├── BuyOneGetOneFreeStrategy.java (Class implementing buy one, get one free discounts)
    │        ├── CartItem.java (Class representing items in the cart)
    │        └── Main.java (Main application class with user interface)
    ├── LICENSE
    └── README.md


## Functionalities

- Application displays all products to user.
- User can add products to the shopping cart.
- Display current Cart Items to users.
- allows user to update the quantity of products in the cart.
- Remove products from the cart.
- Calculate and display the total bill.
- Code Applies discount strategies such as percentage-based discounts and "Buy One Get One Free" offer.
- Generates invoice with detailed itemized information.

## Features
### Use of Design Patterns in code

- Singleton Pattern (ShoppingCart class)  
The ShoppingCart class implements the Singleton Pattern. It ensures that there is only one instance of the ShoppingCart class in the entire application. The Singleton Pattern is achieved through the use of a private static instance variable and a private constructor. The getInstance() method provides access to the single instance.

   ```java
   private static ShoppingCart instance; // Static instance
   private ShoppingCart() {} // Private constructor
   public static ShoppingCart getInstance() { // Public method to get the single instance
       if (instance == null) {
           instance = new ShoppingCart();
       }
       return instance;
   }
   ```

- Strategy Pattern (DiscountStrategy, PercentageDiscountStrategy, and BuyOneGetOneFreeStrategy)  
The Strategy Pattern is employed for handling different discount strategies for products. The DiscountStrategy interface defines a common method, applyDiscount(), which is implemented by concrete classes like PercentageDiscountStrategy and BuyOneGetOneFreeStrategy. This allows for flexible swapping of discount strategies at runtime.

  ```java
  interface DiscountStrategy {
    double applyDiscount(double price, int quantity);
  }
  ```

  ```java
  class PercentageDiscountStrategy implements DiscountStrategy {
    // ...
  }

  class BuyOneGetOneFreeStrategy implements DiscountStrategy {
    // ...
  }
  ```
- Prototype Pattern (Product class)  
The Product class implements the Prototype Pattern. It allows for the cloning of product objects, which can be useful when adding products to the shopping cart while maintaining the original object's state.

  ```java
  class Product implements Cloneable {
      // ...
      public Product clone() throws CloneNotSupportedException {
          return (Product) super.clone();
      }
  }

  ```

### Use of OOP principles in Code
- Encapsulation
defines several classes and Each class encapsulates related data and behavior within its scope
- Inheritance
defined a base class Product and specialized subclasses for different types of products
- Polymorphism

illustration of how OOP concepts are applied
```java
// Encapsulation
class ShoppingCart {
    private Map<String, CartItem> cartItems = new HashMap<>();
    // ...
}

// Inheritance
class Product {
    // Common attributes and behaviors
}

class ElectronicsProduct extends Product {
    // Specialized attributes and behaviors for ElectronicsProduct
}


// Polymorphism
interface DiscountStrategy {
    double applyDiscount(double price, int quantity);
}

class PercentageDiscountStrategy implements DiscountStrategy {
    // Overrides applyDiscount method with specific implementation
}

class BuyOneGetOneFreeStrategy implements DiscountStrategy {
    // Overrides applyDiscount method with specific implementation
}

```

### Use of SOLID Principles in Code

- Single Responsibility Principle (SRP)  
ShoppingCart and Product class have a single responsibility of manages the shopping cart's state and representing a product respectively
- Open-Closed Principle (OCP)  
example of the OCP principle is that New discount strategies can be added by creating new classes that implement the DiscountStrategy interface without modifying existing code
- Interface Segregation Principle (ISP)  
DiscountStrategy interface is relatively focused on a single method, applyDiscount() which aligns with the ISP
- Dependency Inversion Principle (DIP)  
ShoppingCart class depends on the DiscountStrategy interface rather than concrete discount strategy classes. This allows for flexibility in changing or extending discount strategies without modifying the ShoppingCart class

## Usage


## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Git (for cloning the repository)

### Installation

1. Clone the repository:
   ```bash
   https://github.com/kenilghetia/Ei-Assignment-1.git
2. Navigate to the project directory:
   ```bash
   cd ecommerce-shopping-cart
3. Compile the code:
   ```bash
   javac com/ecommerce/*.java

4. Run the application:
   ```bash
   java com.ecommerce.Main
   ```
