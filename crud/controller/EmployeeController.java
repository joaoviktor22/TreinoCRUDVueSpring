package com.treinobrisa.crud.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treinobrisa.crud.entity.Employee;
import com.treinobrisa.crud.service.EmployeeService;

@RestController
@RequestMapping("/employees")
@CrossOrigin("http://localhost:8083/")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
	public Employee AddEmployee(@RequestBody Employee employee) {
		return employeeService.save(employee);
	}
	
	@GetMapping()
	public ArrayList<Employee> retrieveAllStudents() {
		return (ArrayList<Employee>) employeeService.getall();
	}
	
	@GetMapping(path = "/{id}")
	public Employee getEmployee(@PathVariable int id) {
		return employeeService.getEmployee(id);
	}
	
	@PutMapping()
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.update(employee);
	}
	
	@DeleteMapping(path = "/{id}")
	public String deleteEmployee(@PathVariable int id) {
		return employeeService.delete(id);
	}

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
}
