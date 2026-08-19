# 🚀 Employee Management System

A full-stack Employee Management System built using Spring Boot, Spring Security, Hibernate, JPA, Thymeleaf, and MySQL.

This project demonstrates industry-standard backend development practices such as DTO implementation, layered architecture, exception handling, validation, authentication, authorization, and database management.

---

## 📌 Features

- Employee CRUD Operations
- Spring Security Authentication & Authorization
- DTO Pattern
- Global Exception Handling
- Form Validation
- Spring Data JPA & Hibernate
- Thymeleaf UI
- ResponseEntity for API Responses
- MySQL Database Integration
- Soft Delete Functionality
- Clean Layered Architecture

---

## 🛠️ Tech Stack

### Backend
- Java 17
- Spring Boot
- Spring MVC
- Spring Security
- Spring Data JPA
- Hibernate

### Frontend
- Thymeleaf
- HTML
- CSS
- Bootstrap

### Database
- MySQL

### Build Tool
- Maven

---

## 🏗️ Project Structure

```text
src/main/java
│
├── controller
├── service
├── repository
├── dto
├── entity
├── exception
├── config
└── EmployeeManagementApplication
```

---

## 🔄 Application Flow

```text
Client
  │
  ▼
Controller
  │
  ▼
Service
  │
  ▼
Repository
  │
  ▼
MySQL Database
```

---

## 📋 Key Concepts Used

- DTO (Data Transfer Object)
- Layered Architecture
- Dependency Injection
- Spring Security
- Exception Handling
- Validation
- Hibernate ORM
- JPA Repositories
- Thymeleaf Templates
- REST APIs
- ResponseEntity

---

## 🔐 Security Features

- User Registration
- User Login
- Password Encryption using BCrypt
- Role-Based Access Control
- Protected Endpoints

---

## ⚠️ Exception Handling

Implemented centralized exception handling using:

- `@ControllerAdvice`
- Custom Exceptions
- Proper HTTP Status Codes
- User-Friendly Error Messages

---

## 🗄️ Database Schema

### Employee

| Field | Type |
|---------|---------|
| id | Long |
| name | String |
| email | String |
| department | String |
| salary | Double |
| createdAt | LocalDateTime |
| updatedAt | LocalDateTime |
| deleted | Boolean |

---

## 🌐 API Endpoints

| Method | Endpoint | Description |
|---------|----------|-------------|
| GET | /employees | Get All Employees |
| GET | /employees/{id} | Get Employee By ID |
| POST | /employees | Create Employee |
| PUT | /employees/{id} | Update Employee |
| DELETE | /employees/{id} | Delete Employee |

---

## ⚙️ Installation

### Clone Repository

```bash
git clone https://github.com/your-username/Employee-Management-System.git
```

### Move to Project Folder

```bash
cd Employee-Management-System
```

### Configure Database

Update `application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/employee_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
```

### Run Application

```bash
mvn spring-boot:run
```

Application will run on:

```text
http://localhost:8080
```

---

## 📸 Screenshots

### Login Page
![Login Page](images/login.png)

### Dashboard
![Dashboard](images/dashboard.png)

### Employee List
![Employee List](images/employee-list.png)

---

## 🎯 What I Learned

- Building scalable Spring Boot applications
- Implementing DTO Pattern
- Spring Security Authentication
- Exception Handling Best Practices
- Hibernate & JPA
- Database Design
- Thymeleaf Integration
- REST API Development
- Clean Code Principles

---

## 🚀 Future Improvements

- JWT Authentication
- Docker Deployment
- Swagger Documentation
- Pagination & Sorting
- Redis Caching
- Unit Testing
- Integration Testing
- Email Notifications

---

## 👨‍💻 Author

**Priyanshu Singh**

Aspiring Java Backend Developer

- GitHub: https://github.com/your-github
- LinkedIn: https://linkedin.com/in/your-linkedin

---

⭐ If you like this project, give it a star!
