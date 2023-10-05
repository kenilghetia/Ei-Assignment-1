# Ei-Assignments

I have implemented two problem statements in **Java**.  
- **Ecommerce Cart System** - [Repository Link 1](https://github.com/kenilghetia/Ei-Assignment-1) *(This Repository)*  
- **Satellite Command System** - [Repository Link 2](https://github.com/kenilghetia/Ei-Assignment-2)  

---

# E-Commerce Cart System

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Best Practices](#best-practices)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## Features

- Add products to the shopping cart.
- Apply various discount strategies, including percentage-based discounts and "Buy One Get One Free" offers.
- Update the quantity of products in the cart.
- Remove products from the cart.
- Calculate and display the total bill.
- Generate invoices with detailed itemized information.


## Best Practices
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

### Use of SOLID Principles in Code

## Introduction

Welcome to the E-commerce Shopping Cart Application! This Java-based application allows users to add products to their shopping cart, apply discounts, and generate invoices.


## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Git (optional, for cloning the repository)

### Installation

1. Clone the repository:

   ```bash
   https://github.com/kenilghetia/Ei-Assignment-1.git

[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE.md)
