package com.shopbridge.gateway.model;

import com.shopbridge.common.model.ProductBase;

public class ProductDTO extends ProductBase {

    public ProductDTO() {}

    public ProductDTO(Long id, String name, String description, String category, Double price, Integer quantity) {
        super(id, name, description, category, price, quantity);
    }
}