package org.vexelon.springboot.cruddemo.dao;

import java.util.List;

import org.vexelon.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public void delete(int theId);
}
