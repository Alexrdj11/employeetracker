# Employee management

## Overview

The **Employee management** is a Java application that demonstrates database management using JDBC to handle employee and project information. The application connects to a MySQL database, automatically creates the required tables if they don't exist, and provides functionality for basic CRUD operations on employee and project records.

## Features

-  **Database Connection**: Establishes secure connection to MySQL database using JDBC
-  **Auto Table Creation**: Automatically creates Employee and Project tables if they don't exist
-  **Employee Management**: Add, retrieve, and manage employee records
-  **Project Management**: Create and assign projects to employees
-  **CRUD Operations**: Supports Create, Read, Update, and Delete operations (extensible)
-  **DAO Pattern**: Implements Data Access Object pattern for clean code architecture

## Prerequisites

Before running this application, ensure you have:

- **Java 8 or higher** installed on your system
- **MySQL Server** (local or remote instance)
- **MySQL JDBC Driver** (Connector/J) - included in the `lib` folder

## Project Structure

```
EmployeeProjectTracker/
├── src/
│   ├── DBConnection.java      # Database connection management
│   ├── EmployeeDAO.java       # Employee data access operations
│   ├── ProjectDAO.java        # Project data access operations
│   └── Main.java             # Application entry point
├── lib/
│   └── mysql-connector-j-9.4.0.jar  # MySQL JDBC driver
└── EmployeeProjectTracker.md        # This README file
```

## Database Setup

### 1. Create Database

First, create a database in MySQL:

```sql
CREATE DATABASE employee_db;
USE employee_db;
```

### 2. Configure Database Connection

Update the database connection details in your DAO classes (`EmployeeDAO.java` and `ProjectDAO.java`):

```java
private static final String URL = "jdbc:mysql://localhost:3306/employee_db";
private static final String USER = "root";              // Change to your MySQL username
private static final String PASSWORD = "your_password"; // Change to your MySQL password
```

> **Note**: The application automatically creates the necessary tables (`employees` and `projects`) if they don't exist.

## Installation & Usage

### Compilation

Navigate to the project root directory and compile the Java files:

```bash
# Windows
javac -cp ".;lib/mysql-connector-j-9.4.0.jar" src/*.java

### Execution

Run the main application:

```bash
# Windows
java -cp ".;lib/mysql-connector-j-9.4.0.jar" src.Main

## Database Schema

The application creates the following tables automatically:

### Employees Table
- `id` (INT, Primary Key, Auto Increment)
- `name` (VARCHAR)
- `email` (VARCHAR)
- `department` (VARCHAR)

### Projects Table
- `id` (INT, Primary Key, Auto Increment)
- `name` (VARCHAR)
- `description` (TEXT)
- `employee_id` (INT, Foreign Key)

