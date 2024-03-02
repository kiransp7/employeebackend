package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.EmployeeRepository;
import com.app.pojo.Employee;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeServiceImp implements IEmployeeService {

	@Autowired
	private EmployeeRepository employeeRepo;

	public boolean addEmployees(Employee employee) {

		System.out.println(employee);

		if (employee != null)
			employeeRepo.save(employee);
		else
			return false;

		return true;
	}

	@Override
	public List<Employee> getEmployees() {
		List<Employee> allEmp = employeeRepo.findAll();

		return allEmp;
	}

	
	@Override
	public Employee getPerticularEmployee(Integer id) {
		Optional<Employee> emp = employeeRepo.findById(id);
		
		if (emp.isPresent()) {
			return employeeRepo.findById(id).orElse(null);
		}else {
			return null;
		}
	}

	
	@Override
	public boolean deleteEmp(Integer id) {
		
		Optional<Employee> emp = employeeRepo.findById(id);
		boolean present = emp.isPresent();
		
		System.out.println("service Layer");

		if (present == true) {
			employeeRepo.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	
	@Override
	public boolean updatLocation(Integer id, Employee employee) {
		
		Optional<Employee> emp = employeeRepo.findById(id);
		
		if(emp.isPresent()) {
			Employee e= emp.get();
			e.setLocation(employee.getLocation());
			employeeRepo.save(e);
			return true;
		}else 
			return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
