package com.savich.employeeManagement.mapping;

import com.savich.employeeManagement.dto.EmployeeDto;
import com.savich.employeeManagement.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public Employee mapToEmployee(EmployeeDto employeeDto){
        Employee employee=new Employee();
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setDepartmentId(employeeDto.getDepartmentId());
        employee.setJobTitle(employeeDto.getJobTitle());
        employee.setGender(employeeDto.getGender());
        return employee;
    }
}
