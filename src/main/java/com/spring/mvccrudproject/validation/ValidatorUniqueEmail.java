package com.spring.mvccrudproject.validation;

import com.spring.mvccrudproject.reposotory.EmployeeJpa;
import com.spring.mvccrudproject.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Deprecated
@Component
public class ValidatorUniqueEmail implements ConstraintValidator<UniqueEmail, String> {



    private  EmployeeService employeeService;

    @Autowired
    public ValidatorUniqueEmail(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void initialize(UniqueEmail constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        if (email == null || email.isEmpty()) {
            return true;
        }

        return !employeeService.emailExists(email);
    }
}
