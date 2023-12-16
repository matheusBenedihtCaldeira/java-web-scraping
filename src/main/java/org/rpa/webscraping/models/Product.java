package org.rpa.webscraping.models;

import java.awt.*;

public class Product {
    private String description;
    private Double price;

    public Product() {
    }

    public Product(String description, String price) {
        String numericalPrice = price.replaceAll("[R$ .]", "");
        numericalPrice = numericalPrice.replace(",", ".");
        this.description = description;
        this.price = Double.parseDouble(numericalPrice);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}