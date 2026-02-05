package com.shopbridge.soap.model;

import com.shopbridge.common.model.ProductBase;

public class Product extends ProductBase {

    public Product() {}

    public Product(Long id, String name, String description, String category, Double price, Integer quantity) {
        super(id, name, description, category, price, quantity);
    }
}