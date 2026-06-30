Vehicle Management REST API

A production-ready RESTful API built with Spring Boot and PostgreSQL for managing and monitoring a fleet of urban vehicles. The project implements enterprise-grade architectural patterns, ensuring concurrency handling, data decoupling, pagination, and full compliance with REST maturity principles.

🚀 Key Features

* Layered Architecture: Clear separation of concerns between the Web layer (Controllers), Business Logic layer (Services), and Data Access layer (Repositories).
* DTO Pattern & MapStruct: Complete decoupling between database persistence models and the public API contract through the use of Java records and automatic mapping with MapStruct.
* Concurrency Handling (Optimistic Locking): Prevention of race conditions during simultaneous vehicle status updates using JPA’s @Version annotation, returning a 409 Conflict status code in case of collisions.
* Structured Data Validation: Strict validation of incoming payloads using jakarta.validation constraints (@NotBlank, @Min, @Max) to catch malformed data at the Controller level.
* Pagination and Sorting: Optimized read endpoints designed to support large datasets through Spring Data’s Pageable and Page abstractions.
* REST Maturity Level 3 (HATEOAS): Dynamic hypermedia links included in JSON responses to guide clients through available actions (e.g., renting, maintenance) based on the vehicle’s current state.
* Centralized Exception Handling: Global error interception using @RestControllerAdvice to ensure clean, semantic HTTP responses compliant with RFC standards.

⸻

🛠️ Tech Stack & Dependencies

* Java 17 / 21
* Spring Boot 3.x
    * Spring Web
    * Spring Data JPA (Hibernate)
    * Spring HATEOAS
    * Validation
* PostgreSQL (Relational Database)
* MapStruct (DTO Mapping)
* Maven (Project Build and Dependency Management)

⸻

🚦 Setup and Getting Started

Prerequisites

Make sure you have installed:

* JDK 17 or higher
* Maven 3.x
* PostgreSQL (locally or via Docker)
* Git

👥 Clone and Run Locally

1. Clone the repository:
```bash
https://github.com/simone-nicholas/PoliRide-API
```
