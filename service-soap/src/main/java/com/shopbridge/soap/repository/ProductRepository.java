package com.shopbridge.soap.repository;

import com.shopbridge.soap.model.Product;
import org.springframework.stereotype.Repository;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {

    private final List<Product> products = new ArrayList<>();

    @PostConstruct
    public void initData() {
        products.add(new Product(1L, "Laptop", "High performance laptop", "Electronics", 999.99, 10));
        products.add(new Product(2L, "Smartphone", "Latest smartphone model", "Electronics", 699.99, 25));
        products.add(new Product(3L, "Book", "Programming book", "Books", 49.99, 100));
        products.add(new Product(4L, "Chair", "Office chair", "Furniture", 199.99, 15));
        products.add(new Product(5L, "Table", "Wooden table", "Furniture", 299.99, 8));
    }

    public List<Product> findAll() {
        return new ArrayList<>(products);
    }

    public Optional<Product> findById(Long id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();
    }

    public List<Product> findByCategory(String category) {
        return products.stream()
                .filter(product -> product.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    public Product save(Product product) {
        if (product.getId() == null) {
            Long newId = products.stream()
                    .mapToLong(Product::getId)
                    .max()
                    .orElse(0L) + 1;
            product.setId(newId);
        } else {
            products.removeIf(p -> p.getId().equals(product.getId()));
        }
        products.add(product);
        return product;
    }

    public boolean deleteById(Long id) {
        return products.removeIf(product -> product.getId().equals(id));
    }

    public long count() {
        return products.size();
    }
}