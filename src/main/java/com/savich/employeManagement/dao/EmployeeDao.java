package com.savich.employeManagement.dao;

import com.savich.employeManagement.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {


}
