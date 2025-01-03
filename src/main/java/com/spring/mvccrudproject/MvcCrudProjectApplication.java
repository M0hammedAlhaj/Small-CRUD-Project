package com.spring.mvccrudproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.spring.mvccrudproject")
public class MvcCrudProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(MvcCrudProjectApplication.class, args);
    }

}
