package com.app.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.springboot.cruddemo.dao.EmployeeRepository;
import com.app.springboot.cruddemo.entity.Employee;


@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}


	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}


	@Override
	public int getEmployeeCount() {
		// TODO Auto-generated method stub
		return employeeRepository.getEmployeeCount();
	}


	@Override
	public Employee findbyId(int id) {
		// TODO Auto-generated method stub
		Optional<Employee> e = employeeRepository.findById(id);
		Employee emp = e.get();
		return emp;
	}


	@Override
	public void deletebyID(int id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
	}


	@Override
	public void save(Employee theEmployee) {
		// TODO Auto-generated method stub
		employeeRepository.save(theEmployee);
	}


	

	
}
