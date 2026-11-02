# Java Servlet CRUD API

A lightweight REST-style CRUD application built using **Java Servlets, Jakarta Servlet API, Apache Tomcat, Maven, and Java Collections**. This project demonstrates how Java web applications handle HTTP requests and responses using the Servlet lifecycle and an in-memory data store.

## Overview

This project implements user management operations through HTTP endpoints. It uses an in-memory `HashMap` to store and manage user records without requiring an external database.

## Tech Stack

- **Language:** Java
- **Web Technology:** Jakarta Servlets
- **Server:** Apache Tomcat 10.1+
- **Build Tool:** Apache Maven
- **Data Storage:** Java HashMap
- **API Testing:** Apidog

## Features

- Create new users using HTTP POST.
- Retrieve all users using HTTP GET.
- Retrieve an individual user by ID.
- Update existing users using HTTP PUT.
- Delete users using HTTP DELETE.
- Handle HTTP status codes and JSON responses.
- Organize application logic using Servlet, Service, and Model layers.
- Explore the Servlet lifecycle: constructor, `init()`, request handling, and `destroy()`.

## Project Structure

```text
ServletCrudDemo/
│
├── src/
│   └── main/
│       └── java/
│           └── in/
│               └── coderarmy/
│                   ├── model/
│                   │   └── User.java
│                   ├── Service/
│                   │   └── UserService.java
│                   ├── servlet/
│                   │   ├── HelloServlet.java
│                   │   └── UserServlet.java
│                   └── Main.java
│
├── pom.xml
└── README.md
```

## API Endpoints

Base URL: `http://localhost:8080/{context-path}`

| Method | Endpoint | Description |
|---|---|---|
| POST | `/users` | Create a user |
| GET | `/users` | Retrieve all users |
| GET | `/users?id=1` | Retrieve user by ID |
| PUT | `/users?id=1` | Update a user |
| DELETE | `/users?id=1` | Delete a user |
| GET | `/hello` | Test servlet endpoint |

### Example User Parameters

```text
id       = 1
name     = Meet
email    = meet@gmail.com
mobile   = 9988555124
```

## Getting Started

### Prerequisites

- Java JDK 17 or compatible version
- Apache Maven
- Apache Tomcat 10.1 or newer
- Apidog or Postman (for API testing)

### 1. Clone the repository

```bash
git clone https://github.com/YOUR_USERNAME/java-servlet-crud-api.git
```

### 2. Navigate to the project

```bash
cd java-servlet-crud-api
```

### 3. Build the application

```bash
mvn clean package
```

### 4. Deploy to Tomcat

Copy the generated WAR file from the `target/` directory into Tomcat's `webapps/` directory.

Start Tomcat and access the application using:

```text
http://localhost:8080/{context-path}/hello
```

Replace `{context-path}` with the deployed WAR application's context path.

## Important Notes

- User records are stored in an in-memory HashMap.
- Data is not persistent and is lost when the application restarts.
- The application uses Jakarta Servlet APIs and requires a compatible Tomcat version.
- API parameters and response formats depend on the servlet implementation.

## Learning Objectives

This project explores:

- Java Servlet architecture
- HTTP request and response handling
- REST API fundamentals
- Servlet lifecycle
- CRUD operations
- Java Collections Framework
- Separation of concerns using layered architecture
- Maven-based web application deployment

## Future Improvements

- Integrate MySQL or PostgreSQL.
- Introduce a DAO layer.
- Add input validation and exception handling.
- Implement proper JSON serialization.
- Add authentication and authorization.
- Write automated API tests.

---

**Built with Java, Jakarta Servlets, and curiosity.**
