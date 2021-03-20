package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Employee;
import com.example.demo.repository.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepo empRepo;
	
	public List<Employee> getEmployees(){
		return empRepo.findAll();
	}
	
	public Optional<Employee> getEmployeeById(Long id) {
		return empRepo.findById(id);
	}
	
	public void createEmp(Employee emp) {
		empRepo.save(emp);
	}
}
