# Book Management REST API

An elegant, production-ready RESTful API built with **Spring Boot** and **PostgreSQL** to manage a book catalog. This project showcases enterprise-grade patterns, including DTO-based communication, structured logging, centralized error handling, and robust data persistence.

## 🚀 Key Features

* **Layered Architecture:** Clear separation of concerns across Web (Controllers), Business Logic (Services), and Data Access (Repositories) layers to ensure maximum maintainability and testability.
* **DTO Pattern:** Secure and optimized data transfer using modern Java `record` types, decoupling the internal database entity model from the public API contract.
* **Data Validation:** Strict inbound payload validation using `jakarta.validation` constraints (e.g., `@NotBlank`, `@Size`, `@Min`) to reject malformed data at the edge.
* **Centralized Exception Handling:** Uniform and secure HTTP error responses via a `@RestControllerAdvice`, mapping internal domain exceptions into clean, semantic, RFC-compliant JSON errors.
* **Database Seeding:** Automated initial data population on application startup with safe conditional checks to pre-populate the PostgreSQL database with standard reference data.
* **Comprehensive Logging:** Multi-level structured logs (`TRACE` to `INFO`) written concurrently to both the standard console output and a time-based rolling file for production observability.

---

## 🛠️ Tech Stack & Dependencies

* **Java 17 / 21**
* **Spring Boot 3.x**
    * Spring Web (RESTful Endpoints)
    * Spring Data JPA (Hibernate ORM)
    * Validation (`jakarta.validation-api`)
* **PostgreSQL** (Production-ready Relational Database)
* **Maven** (Project Management and Build Automation)

---

## 🚦 Getting Started

### Prerequisites
Before you begin, ensure you have the following installed:
* **JDK 17** or higher
* **Maven 3.x**
* **PostgreSQL** instance running locally or via Docker
* **Git** installed on your machine

### 👥 How to Clone and Run Locally

Follow these steps to clone the repository, configure the environment, and spin up the backend application on your local machine:

1. **Clone the repository:**
   Open your terminal and execute the following command:
   ```bash
   git clone [https://github.com/Waldren56/Books-REST-API.git](https://github.com/Waldren56/Books-REST-API.git)
   cd Books-REST-API
