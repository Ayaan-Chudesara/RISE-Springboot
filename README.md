# RISE
Task:  Implement CRUD operations using REST API architecture


Product-Category CRUD Application
=================================

A full-featured Spring Boot project performing CRUD operations on two independent entities: `Product` and `Category`, using a relational SQL database.

Technologies Used
-----------------
- Java 17
- Spring Boot 3.x
- Spring Data JPA
- SQL Database
- Maven
- RESTful API



How to Run the Project
----------------------

1. Clone the Repository
   git clone https://github.com/yourusername/ProductCategoryApp.git
   cd ProductCategoryApp

2. Build with Maven
   ./mvnw clean install

3. Run the Spring Boot App
   ./mvnw spring-boot:run

API Reference
-------------

Product Endpoints:
- GET    /api/products       : Get all products
- GET    /api/products/{id}  : Get product by ID
- POST   /api/products       : Add new product
- PUT    /api/products/{id}  : Update product by ID
- DELETE /api/products/{id}  : Delete product by ID

Category Endpoints:
- GET    /api/categories       : Get all categories
- GET    /api/categories/{id}  : Get category by ID
- POST   /api/categories       : Add new category
- PUT    /api/categories/{id}  : Update category by ID
- DELETE /api/categories/{id}  : Delete category by ID

Testing the API
---------------

Sample JSON for POST /api/products:
{
  "name": "Wireless Earbuds",
  "brand": "Sony",
  "price": 149.99
}

Sample JSON for POST /api/categories:
{
  "name": "Audio",
  "description": "Audio devices and accessories",
  "type": "Electronics"
}


Features Summary
----------------
- Basic CRUD for two entities
- REST APIs using Spring Web
- Configurable for MySQL/PostgreSQL
- Well-structured layered architecture

