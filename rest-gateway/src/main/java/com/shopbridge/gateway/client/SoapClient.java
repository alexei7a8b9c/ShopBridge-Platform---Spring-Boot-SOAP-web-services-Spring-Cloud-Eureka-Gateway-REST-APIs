package com.shopbridge.gateway.client;

import com.shopbridge.gateway.model.ProductDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;
import java.util.List;

@Component
public class SoapClient {

    private final RestTemplate restTemplate;

    @Value("${soap.service.url:http://localhost:8081}")
    private String soapServiceUrl;

    public SoapClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<ProductDTO> getAllProducts() {
        String url = soapServiceUrl + "/api/products";
        ResponseEntity<ProductDTO[]> response = restTemplate.getForEntity(url, ProductDTO[].class);
        return Arrays.asList(response.getBody());
    }

    public ProductDTO getProductById(Long id) {
        String url = soapServiceUrl + "/api/products/" + id;
        return restTemplate.getForObject(url, ProductDTO.class);
    }

    public ProductDTO createProduct(ProductDTO productDTO) {
        String url = soapServiceUrl + "/api/products";
        return restTemplate.postForObject(url, productDTO, ProductDTO.class);
    }

    public ProductDTO updateProduct(ProductDTO productDTO) {
        String url = soapServiceUrl + "/api/products/" + productDTO.getId();
        restTemplate.put(url, productDTO);
        return getProductById(productDTO.getId());
    }

    public boolean deleteProduct(Long id) {
        String url = soapServiceUrl + "/api/products/" + id;
        try {
            restTemplate.delete(url);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public long getProductCount() {
        String url = soapServiceUrl + "/api/products/count";
        return restTemplate.getForObject(url, Long.class);
    }

    public List<ProductDTO> getProductsByCategory(String category) {
        String url = soapServiceUrl + "/api/products/category/" + category;
        ResponseEntity<ProductDTO[]> response = restTemplate.getForEntity(url, ProductDTO[].class);
        return Arrays.asList(response.getBody());
    }
}