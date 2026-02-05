ShopBridge Platform
Overview
ShopBridge Platform is a microservices-based e-commerce system that demonstrates integration between SOAP and REST web services using Spring Cloud technologies. The platform provides a unified product management system with multiple service layers and a modern web interface.

Architecture
The platform follows a microservices architecture with the following components:

Service Components
Discovery Server (Eureka) - Service registry and discovery (Port: 8761)

API Gateway - Main entry point with routing and CORS configuration (Port: 8080)

SOAP Service - SOAP-based product service with web interface (Port: 8081)

REST Gateway - REST API gateway for SOAP service integration (Port: 8082)

Common Core - Shared models and utilities

Technology Stack
Backend: Java 11, Spring Boot 2.7.18, Spring Cloud

Frontend: HTML5, CSS3, JavaScript (ES6+)

Build Tool: Maven

Service Discovery: Netflix Eureka

API Gateway: Spring Cloud Gateway

Web Services: Spring-WS (SOAP), Spring Web (REST)

Features
Product management (CRUD operations)

Dual protocol support (SOAP and REST)

Service discovery and load balancing

CORS-enabled API endpoints

Modern responsive web interface

Real-time API response visualization

Service health monitoring

Prerequisites
Java 11 or higher

Maven 3.6 or higher

Modern web browser

Installation & Setup
1. Clone and Build
   bash
   git clone <repository-url>
   cd shopbridge-platform
   mvn clean install
2. Start Services (in order)
   bash
# Start Discovery Server
cd discovery-server
mvn spring-boot:run

# Start SOAP Service (in new terminal)
cd service-soap
mvn spring-boot:run

# Start REST Gateway (in new terminal)
cd rest-gateway
mvn spring-boot:run

# Start API Gateway (in new terminal)
cd api-gateway
mvn spring-boot:run
Access Points
Service Endpoints
Eureka Dashboard: http://localhost:8761

API Gateway: http://localhost:8080

SOAP Service UI: http://localhost:8081

REST Gateway: http://localhost:8082

API Endpoints
REST API: http://localhost:8080/api/products

SOAP WSDL: http://localhost:8081/ws/products.wsdl

SOAP Endpoint: http://localhost:8081/ws