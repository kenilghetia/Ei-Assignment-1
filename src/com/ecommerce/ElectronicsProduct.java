package com.ecommerce;

// ElectronicsProduct subclass
class ElectronicsProduct extends Product {
    private String brand;

    public ElectronicsProduct(String name, double price, boolean available, String brand, DiscountStrategy discountStrategy) {
        super(name, price, available, discountStrategy);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return "ElectronicsProduct [name=" + getName() + ", price=" + getPrice() + ", available=" + isAvailable() + ", brand=" + brand + "]";
    }
}
