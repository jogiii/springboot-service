# Review Service

## Overview
Review Service provides API to get the review details for a specific product

## Project Details
1. **Build RESTFul APIs** using `@RestController` and use of short annotations `@GetMapping`, `@PostMapping`, `@PutMapping`, and `@DeleteMapping`
2. **Service Layer** development using `@Service` to provide business logic to `@RestController`
3. **Global API Exception Handler** using `ApiExceptionHandler` to customize the API response for errors
4. **API Documentation** using Spring OpenAPI and Swagger configuration using `OpenApiConfig`
5. **API Logging** using `ApiLoggingFilterConfig` to log API request and response
6. **Boilerplate Code** generation using `Lombok` annotations such as `@Data`, `@Value`, `@ToString`, `@Getters`, and `@Setters`
7. **Unit and Integration Tests** for Controller and Service Layer
8. **Implement CRUD Operation** using *Spring Boot JPA* module
9. Used **H2 memory database** which loads the `Review` table schema and few records on application startup from `schema.sql` and `data.sql` files in `/resources` folder
10. **Boilerplate Mapping Code** generation using `MapStruct`
11. **Authentication and JWT access token** is required to perform write, update and delete operations using *Spring Boot Web Security* module
