package com.app.springboot.cruddemo.service;

import java.util.List;

import com.app.springboot.cruddemo.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	public int getEmployeeCount();
	public Employee findbyId(int id);
	public void deletebyID(int id);
	public void save(Employee theEmployee);	
}
