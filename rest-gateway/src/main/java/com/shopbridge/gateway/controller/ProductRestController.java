package com.shopbridge.gateway.controller;

import com.shopbridge.common.model.ApiResponse;
import com.shopbridge.gateway.client.SoapClient;
import com.shopbridge.gateway.model.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductRestController {

    private final SoapClient soapClient;

    public ProductRestController(SoapClient soapClient) {
        this.soapClient = soapClient;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ProductDTO>>> getAllProducts() {
        List<ProductDTO> products = soapClient.getAllProducts();
        return ResponseEntity.ok(ApiResponse.success(products));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductDTO>> getProductById(@PathVariable Long id) {
        try {
            ProductDTO product = soapClient.getProductById(id);
            return ResponseEntity.ok(ApiResponse.success(product));
        } catch (Exception e) {
            return ResponseEntity.ok(ApiResponse.error("Product not found"));
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ProductDTO>> createProduct(@RequestBody ProductDTO productDTO) {
        ProductDTO createdProduct = soapClient.createProduct(productDTO);
        return ResponseEntity.ok(ApiResponse.success("Product created successfully", createdProduct));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductDTO>> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        productDTO.setId(id);
        ProductDTO updatedProduct = soapClient.updateProduct(productDTO);
        return ResponseEntity.ok(ApiResponse.success("Product updated successfully", updatedProduct));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteProduct(@PathVariable Long id) {
        boolean deleted = soapClient.deleteProduct(id);
        if (deleted) {
            return ResponseEntity.ok(ApiResponse.success("Product deleted successfully", null));
        } else {
            return ResponseEntity.ok(ApiResponse.error("Product not found"));
        }
    }

    @GetMapping("/count")
    public ResponseEntity<ApiResponse<Long>> getProductCount() {
        long count = soapClient.getProductCount();
        return ResponseEntity.ok(ApiResponse.success(count));
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<ApiResponse<List<ProductDTO>>> getProductsByCategory(@PathVariable String category) {
        List<ProductDTO> products = soapClient.getProductsByCategory(category);
        return ResponseEntity.ok(ApiResponse.success(products));
    }
}