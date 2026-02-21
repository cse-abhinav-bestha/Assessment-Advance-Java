package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringCoreAssessment1Application {
    public static void main(String[] args) {
    	ConfigurableApplicationContext context = SpringApplication.run(SpringCoreAssessment1Application.class, args);
        StorageServices storageService = context.getBean(StorageServices.class);
        storageService.storeFile("assignment.pdf");
        
        StorageServices local1 = context.getBean(LocalStorageService.class);
        local1.storeFile("photo1.png");

        StorageServices local2 = context.getBean(LocalStorageService.class);
        local2.storeFile("photo2.png");
        context.close();

    }
}