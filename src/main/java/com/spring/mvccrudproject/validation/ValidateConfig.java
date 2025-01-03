package com.spring.mvccrudproject.validation;

import com.spring.mvccrudproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

@Configuration
@Deprecated
public class ValidateConfig {

    private EmployeeService employeeService;

    @Autowired
    public ValidateConfig(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @Bean
    public ValidatorUniqueEmail validatorUniqueEmail() {
        return new ValidatorUniqueEmail(employeeService);
    }
}
