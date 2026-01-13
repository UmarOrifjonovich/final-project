# Product Management System – REST API

## Description
Spring Boot REST API for managing products using layered architecture
(Controller, Service, Repository, Domain, Support).

## Technologies Used
- Java 17
- Spring Boot
- Spring Data JPA
- H2 In-Memory Database
- Postman (API testing)

## API Endpoints
- POST /api/v1/products
- GET /api/v1/products/{id}
- GETALL /api/v1/products
- PUT /api/v1/products/{id}
- DELETE /api/v1/products/{id}

### Application Startup (PowerShell)

The application was built and started using Maven Wrapper.

![PowerShell Run](Screenshots/powershell-run.png)

## Functionality Proof (Postman)

### Create Product
![POST](Screenshots/01-postman-post.png)

### Get Product by ID
![GET](Screenshots/02-postman-get.png)

### Get ALL Products
![GET ALL](Screenshots/06-postman-getall.png)

### Update Product
![PUT](Screenshots/03-postman-put.png)

### Delete Product
![DELETE](Screenshots/04-postman-delete.png)

### Database (H2 Console)
![H2](Screenshots/05-h2-console.png)
