package com.spring.mvccrudproject.service;

import com.spring.mvccrudproject.entity.Employee;
import com.spring.mvccrudproject.reposotory.EmployeeJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing employee-related operations.
 * This class provides methods to perform CRUD operations on the Employee entity.
 */
@Service
public class EmployeeService {

    private final EmployeeJpa employeeJpa;

    /**
     * Constructs an EmployeeService with the specified EmployeeJpa repository.
     *
     * @param employeeJpa the repository used for database operations.
     */
    @Autowired
    public EmployeeService(EmployeeJpa employeeJpa) {
        this.employeeJpa = employeeJpa;
    }

    /**
     * Adds a new employee to the database.
     *
     * @param employee the employee to be added.
     */
    public void addEmployee(Employee employee) {
        employeeJpa.save(employee);
    }

    /**
     * Updates an existing employee in the database.
     * If the employee is not null, it will be saved (updated) in the database.
     *
     * @param employee the employee to be updated.
     */
    public void updateEmployee(Employee employee) {
        if (employee != null) {
            employeeJpa.save(employee);
        }
    }

    /**
     * Deletes an employee from the database by their ID.
     * If the ID is not null, the employee with the specified ID will be deleted.
     *
     * @param id the ID of the employee to be deleted.
     */
    public void deleteEmployee(Integer id) {
        if (id != null) {
            employeeJpa.deleteById(id);
        }
    }

    /**
     * Retrieves a list of all employees from the database.
     *
     * @return a list of all employees.
     */
    public List<Employee> getAllEmployee() {
        return employeeJpa.findAll();
    }

    /**
     * Retrieves an employee by their ID.
     * If the employee is not found, a RuntimeException is thrown.
     *
     * @param id the ID of the employee to be retrieved.
     * @return the employee with the specified ID.
     * @throws RuntimeException if the employee is not found.
     */
    public Employee getEmployeeById(Integer id) {
        return employeeJpa.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public boolean emailExists(String email) {
        return employeeJpa.existsByEmail(email);
    }
}