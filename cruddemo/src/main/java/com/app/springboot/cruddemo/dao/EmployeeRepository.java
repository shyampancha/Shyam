package com.app.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.springboot.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query(value = "select count(id) from Employee")
	public int getEmployeeCount();
	
	
//	public String deleteEmployee();
	
}
