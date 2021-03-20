package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Employee;
import com.example.demo.repository.EmployeeRepo;
import com.example.demo.services.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	public EmployeeController() {
		super();
		//Employee e1 = new Employee();//"id1", "name1", "it", 100.00F);
//		Employee e2 = new Employee("id2", "name2", "admin", 200.00F);
//		Employee e3 = new Employee("id3", "name3", "mgr", 300.00F);
//		Employee e4 = new Employee("id3", "name3", "mgr", 300.00F);
		Employee e5 = new Employee(null, null, null, null);
		
		
//		listEmp.add(e4);
//		listEmp.add(e2);
//		listEmp.add(e3);
//		listEmp.add(e5);
	}

	List<Employee> listEmp = new ArrayList<Employee>();
	
	@Autowired
	EmployeeService empService;
	
	@GetMapping("/")
	//@RequestMapping(value="/", method=RequestMethod.GET, produces = {"application/xml"})
	public List<Employee> getEmployees(){
		return empService.getEmployees();
	}
	
	public List<Employee> getEmpList(){
		
		return listEmp;
	}
	
	//@GetMapping("/{empId}")
	@RequestMapping(value="/{empId}", method=RequestMethod.GET, produces = {"application/xml"})
	public Optional<Employee> getEmployeeById(@PathVariable Long empId) {
		//return (Employee) getEmpList().stream().filter(emp -> emp.getId().equals(empId));
		return empService.getEmployeeById(empId);
	}
	
	@PostMapping("/addEmployee")
	public String addEmployee(@RequestBody Employee emp) {
//		listEmp.add(emp);
//		System.out.println(emp);
		empService.createEmp(emp);
		return "employee created";
	}
	
	
}
