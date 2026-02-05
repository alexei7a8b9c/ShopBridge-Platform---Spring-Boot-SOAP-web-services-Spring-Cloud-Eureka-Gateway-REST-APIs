package com.shopbridge.soap.service;

import com.shopbridge.soap.model.Product;
import com.shopbridge.soap.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product productDetails) {
        productDetails.setId(id);
        return productRepository.save(productDetails);
    }

    public boolean deleteProduct(Long id) {
        return productRepository.deleteById(id);
    }

    public long getProductCount() {
        return productRepository.count();
    }
}