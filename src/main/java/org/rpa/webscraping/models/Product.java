package org.rpa.webscraping.models;

public class Product {
    private String description;
    private String price;

    public Product() {
    }

    public Product(String description, String price) {
        this.description = description;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "description='" + description + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}