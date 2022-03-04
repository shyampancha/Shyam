package com.app.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.springboot.cruddemo.entity.Employee;
import com.app.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;
	
	public EmployeeRestController()
	{
		
	}

	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll()
	{
		return employeeService.findAll();
	}
	
	
	@GetMapping("/employees/count")
	public int getCount()
	{
		return employeeService.getEmployeeCount();
	}
	
	@GetMapping("/employees/{employeeID}")
	public Employee getEmployee(@PathVariable int employeeID)
	{
		Employee theEmployee = employeeService.findbyId(employeeID);
		if(theEmployee==null)
		{
			throw new RuntimeException("Employee Id not Found" + employeeID);
		}
		return theEmployee;
		
	}
	
	@GetMapping("/employee/{emloyeeID}")
	public String deleteEmployee(@PathVariable int emloyeeID)
	{		
		employeeService.deletebyID(emloyeeID);	
		return "Deleted";
	}
	
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee)
	{
		theEmployee.setId(0);
		employeeService.save(theEmployee);
		return theEmployee;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee)
	{
		employeeService.save(theEmployee);
		return theEmployee;
	}
}
