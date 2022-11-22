package com.treinobrisa.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treinobrisa.crud.entity.Employee;
import com.treinobrisa.crud.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee save(Employee emp) {
		return employeeRepository.save(emp);
	}
	
	public Employee getEmployee(int id) {
		return employeeRepository.findById(id).get();
	}
	
	public List<Employee> getall() {
		return employeeRepository.findAll();
	}
	
	public Employee update(Employee employee) {
		Employee emp = employeeRepository.findById(employee.getId()).get();
		emp.setName(employee.getName());
		emp.setAge(employee.getAge());
	
		return employeeRepository.save(emp);
	}
	
	public String delete(int id) {
		employeeRepository.deleteById(id);
		return "Entity Deleted " + id;
	}
	public EmployeeRepository getEmployeeRepository() {
		return employeeRepository;
	}

	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
}
