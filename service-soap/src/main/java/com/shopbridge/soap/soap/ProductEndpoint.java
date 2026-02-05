package com.shopbridge.soap.soap;

import com.shopbridge.soap.model.Product;
import com.shopbridge.soap.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import java.util.ArrayList;
import java.util.List;

@Endpoint
public class ProductEndpoint {

    private static final String NAMESPACE_URI = "http://shopbridge.com/soap/model";

    @Autowired
    private ProductService productService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductRequest")
    @ResponsePayload
    public GetProductResponse getProduct(@RequestPayload GetProductRequest request) {
        Long productId = request.getId();
        Product product = productService.getProductById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));

        GetProductResponse response = new GetProductResponse();
        response.setProduct(product);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllProductsRequest")
    @ResponsePayload
    public GetAllProductsResponse getAllProducts(@RequestPayload GetAllProductsRequest request) {
        List<Product> products = productService.getAllProducts();

        GetAllProductsResponse response = new GetAllProductsResponse();
        response.getProducts().addAll(products);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createProductRequest")
    @ResponsePayload
    public CreateProductResponse createProduct(@RequestPayload CreateProductRequest request) {
        Product product = request.getProduct();
        Product createdProduct = productService.createProduct(product);

        CreateProductResponse response = new CreateProductResponse();
        response.setProduct(createdProduct);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteProductRequest")
    @ResponsePayload
    public DeleteProductResponse deleteProduct(@RequestPayload DeleteProductRequest request) {
        Long productId = request.getId();
        boolean deleted = productService.deleteProduct(productId);

        DeleteProductResponse response = new DeleteProductResponse();
        response.setSuccess(deleted);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductCountRequest")
    @ResponsePayload
    public GetProductCountResponse getProductCount(@RequestPayload GetProductCountRequest request) {
        long count = productService.getProductCount();

        GetProductCountResponse response = new GetProductCountResponse();
        response.setCount(count);
        return response;
    }

    public static class GetProductRequest {
        private Long id;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
    }

    public static class GetProductResponse {
        private Product product;

        public Product getProduct() {
            return product;
        }

        public void setProduct(Product product) {
            this.product = product;
        }
    }

    public static class GetAllProductsRequest {
        private String dummy;

        public String getDummy() {
            return dummy;
        }

        public void setDummy(String dummy) {
            this.dummy = dummy;
        }
    }

    public static class GetAllProductsResponse {
        private List<Product> products = new ArrayList<>();

        public List<Product> getProducts() {
            return products;
        }

        public void setProducts(List<Product> products) {
            this.products = products;
        }
    }

    public static class CreateProductRequest {
        private Product product;

        public Product getProduct() {
            return product;
        }

        public void setProduct(Product product) {
            this.product = product;
        }
    }

    public static class CreateProductResponse {
        private Product product;

        public Product getProduct() {
            return product;
        }

        public void setProduct(Product product) {
            this.product = product;
        }
    }

    public static class DeleteProductRequest {
        private Long id;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
    }

    public static class DeleteProductResponse {
        private boolean success;

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }
    }

    public static class GetProductCountRequest {
        private String dummy;

        public String getDummy() {
            return dummy;
        }

        public void setDummy(String dummy) {
            this.dummy = dummy;
        }
    }

    public static class GetProductCountResponse {
        private Long count;

        public Long getCount() {
            return count;
        }

        public void setCount(Long count) {
            this.count = count;
        }
    }
}