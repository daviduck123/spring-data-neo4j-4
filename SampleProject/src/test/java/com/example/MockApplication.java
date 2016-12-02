package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.example"})
@EnableAutoConfiguration
public class MockApplication {
	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(MockApplication.class);
		springApplication.run(args);
    }
}