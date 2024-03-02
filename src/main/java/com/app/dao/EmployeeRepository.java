package com.app.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.pojo.Employee;

@Repository
public interface EmployeeRepository extends  JpaRepository<Employee, Integer> {

}
