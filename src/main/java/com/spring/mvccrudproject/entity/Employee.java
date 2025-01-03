package com.spring.mvccrudproject.entity;

import com.spring.mvccrudproject.validation.UniqueEmail;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Objects;

/**
 * Represents an Employee entity in the system.
 * This class is mapped to the "employees" table in the database.
 */
@Entity
@Table(name = "employees")
public class Employee {

    /**
     * Unique identifier for the employee.
     * This field is auto-generated by the database.
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    /**
     * The first name of the employee.
     */
    @Column(name = "first_name")
    private String firstName;

    /**
     * The last name of the employee.
     * This field is required and must not be empty.
     */
    @NotNull(message = "Must be required")
    @Size(min = 1, message = "Must be required")
    @Column(name = "last_name")
    private String lastName;

    /**
     * The email address of the employee.
     * Test
     */
//    @UniqueEmail
    @Email
    private String email;

    /**
     * Gets the unique identifier of the employee.
     *
     * @return the employee's ID.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the employee.
     *
     * @param id the employee's ID.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the first name of the employee.
     *
     * @return the employee's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the employee.
     *
     * @param firstName the employee's first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the employee.
     *
     * @return the employee's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the employee.
     *
     * @param lastName the employee's last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the email address of the employee.
     *
     * @return the employee's email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the employee.
     *
     * @param email the employee's email address.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Compares this employee to another object for equality.
     * Two employees are considered equal if they have the same ID.
     *
     * @param o the object to compare to.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    /**
     * Generates a hash code for this employee based on the ID.
     *
     * @return the hash code for this employee.
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    /**
     * Returns a string representation of the employee.
     *
     * @return a string containing the employee's details.
     */
    @Override
    public String toString() {
        return "Employee{" +
                "lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", id=" + id +
                '}';
    }
}