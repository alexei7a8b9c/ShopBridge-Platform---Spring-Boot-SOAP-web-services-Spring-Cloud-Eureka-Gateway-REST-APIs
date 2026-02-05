package com.shopbridge.soap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SoapApplication {
    public static void main(String[] args) {
        SpringApplication.run(SoapApplication.class, args);
        System.out.println("=========================================");
        System.out.println("SOAP Service Started!");
        System.out.println("=========================================");
        System.out.println("Frontend:");
        System.out.println(" • http://localhost:8081");
        System.out.println("SOAP Web Service:");
        System.out.println(" • WSDL: http://localhost:8081/ws/products.wsdl");
        System.out.println(" • Endpoint: http://localhost:8081/ws");
        System.out.println("REST API Endpoints:");
        System.out.println(" • GET http://localhost:8081/api/products");
        System.out.println(" • GET http://localhost:8081/api/products/{id}");
        System.out.println(" • POST http://localhost:8081/api/products");
        System.out.println(" • PUT http://localhost:8081/api/products/{id}");
        System.out.println(" • DELETE http://localhost:8081/api/products/{id}");
        System.out.println("=========================================");
    }
}