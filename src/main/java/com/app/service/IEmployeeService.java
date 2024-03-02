package com.app.service;

import java.util.List;

import com.app.pojo.Employee;

public interface IEmployeeService {
	
	public boolean addEmployees(Employee employee);
	
	public List<Employee> getEmployees();
	
	public Employee getPerticularEmployee(Integer id);
	
	public boolean deleteEmp(Integer id);
	
	public boolean updatLocation(Integer id, Employee employee);
	
	
}
