package com.spring.mvccrudproject.reposotory;

import com.spring.mvccrudproject.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeJpa extends JpaRepository<Employee, Integer> {

    boolean existsByEmail(String email);

    Employee getEmployeeByEmail(String email);
}
