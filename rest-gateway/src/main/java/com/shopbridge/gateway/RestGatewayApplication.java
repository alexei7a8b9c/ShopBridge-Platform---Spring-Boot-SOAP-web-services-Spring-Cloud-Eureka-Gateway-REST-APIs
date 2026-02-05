package com.shopbridge.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RestGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestGatewayApplication.class, args);
        System.out.println("=========================================");
        System.out.println("REST Gateway Started!");
        System.out.println("=========================================");
        System.out.println("REST API Endpoints:");
        System.out.println(" • GET http://localhost:8082/api/products");
        System.out.println(" • GET http://localhost:8082/api/products/{id}");
        System.out.println(" • POST http://localhost:8082/api/products");
        System.out.println(" • PUT http://localhost:8082/api/products/{id}");
        System.out.println(" • DELETE http://localhost:8082/api/products/{id}");
        System.out.println("=========================================");
    }
}