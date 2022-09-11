package com.savich.employeeManagement.dao;

import com.savich.employeeManagement.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {


}
