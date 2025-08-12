# 💳 Bill Payment System

A modular bill payment system built using **Spring Boot 3.5**, **Spring Modulith**, and a clean layered architecture. The system supports handling bills, and processing payments using different strategies.

---

## 📁 Project Structure

This project is organized into separate Maven modules for clean separation of concerns:

billPayment/
│
├── billPayment-api
├── billPayment-application
├── billPayment-controller
├── billPayment-service
├── billPayment-persistence
└── README.md

---

## Service Layer

The Service Layer contains the core business logic of the application:

- **UserAppService:**  
  Responsible for user registration and authentication.

- **BillAppService:**  
  Handles adding new bills and fetching bills by username or bill ID.

- **PaymentService:**  
  Manages bill payments and throws exceptions such as `BillPaidException` and `NotFoundBillException` when appropriate.

These services are injected into the controllers to separate concerns and improve testability.

---

## Controllers

- **UserController:**  
  Handles user-related requests like registration and login. Utilizes JWT tokens for authentication.

- **BillController:**  
  Manages bill-related operations such as adding bills and retrieving bills.

- **PaymentController:**  
  Processes bill payments.

Each controller implements a corresponding facade interface to define API contracts.

---

## Aspect-Oriented Programming (AOP)

AOP is used to implement centralized logging of service methods without cluttering the business logic.

### ServiceInterceptorAspect

- This aspect intercepts all methods in classes annotated with `@RestController`.
- Logs method entry with input parameters (`@Before` advice).
- Logs method exit with returned results (`@AfterReturning` advice).

**Benefits:**
- Separation of cross-cutting concerns (logging).
- Cleaner and more maintainable code.
- Easier debugging and monitoring of service method calls.

### Example Logs

---
## 🚀 Features

- Bill payment with different strategies (Factory Pattern)
- Custom exceptions:
    - `NotFoundBillException`: Bill not found
    - `BillPaidException`: Bill has already been paid
- Uses **Spring Modulith** for modular structure
- Integration and unit tests using Mockito & JUnit 5

---

## 🧪 Testing

The project contains both **unit tests** and **integration tests** for core components:

- Test successful payment
- Test bill not found scenario
- Test already paid bill
- Tests are placed under `billPayment-service`

---

## 🧾 API Documentation

After running the application, Swagger UI is available at:

http://localhost:8080/swagger-ui.html
---

## 🛠 How to Build & Run

To build the project:

---
# Build And Deploy stage
This project is fully dockerized and supports automated build and deployment workflows.

The application is packaged into a Docker image.

We use GitHub and GitHub Actions to automate:

Build

Test

Docker image creation

Deployment to the target environment (e.g., staging or production)

This ensures continuous integration and delivery with every push or pull request.






