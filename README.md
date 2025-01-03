# Small CRUD Project

This is a Spring MVC project that provides a simple Employee Directory application with CRUD (Create, Read, Update, Delete) functionality.

## Features

- List all employees
- Add a new employee
- Update existing employee details
- Delete an employee

## Technologies Used

- **Java**: Backend development
- **Spring Framework**: MVC architecture, Dependency Injection, Validation
- **Thymeleaf**: For building dynamic web pages
- **Hibernate/JPA**: For database interaction
- **MySQL**: Database for storing employee data

## Project Structure

- **Controller Layer**: Manages HTTP requests and responses (`ControllerEmployee.java`).
- **Service Layer**: Contains business logic (`EmployeeService.java`).
- **Repository Layer**: Handles database interactions.
- **Entity Layer**: Represents database entities (`Employee.java`).

## Endpoints

| Endpoint                     | HTTP Method | Description                   |
|------------------------------|-------------|-------------------------------|
| `/employeeDirectory/`        | GET         | View employee directory       |
| `/employeeDirectory/add`     | GET         | Display add employee form     |
| `/employeeDirectory/submitAdd` | POST        | Submit new employee data      |
| `/employeeDirectory/update`  | POST        | Display update employee form  |
| `/employeeDirectory/submitUpdate` | POST      | Submit updated employee data  |
| `/employeeDirectory/delete`  | GET         | Delete an employee by ID      |

## How to Run the Project

1. Clone the repository:
   ```bash
   git clone https://github.com/M0hammedAlhaj/Small-CRUD-Project.git
   cd Small-CRUD-Project
