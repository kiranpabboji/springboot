package com.example.demo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entities.Employee;
import com.example.demo.repository.EmployeeRepo;

@SpringBootApplication
public class RestApiDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiDemoApplication.class, args);
	}

	@Autowired
	EmployeeRepo empRepo;
	
	@PostConstruct
	public void addEmployee() {
		empRepo.save(new Employee(101L, "emp1", "id", 101.0F));
		empRepo.save(new Employee(103L, "emp1", "id", 101.0F));
		empRepo.save(new Employee(104L, "emp1", "id", 101.0F));
	}
}
