package com.savich.employeeManagement.mapping;

import com.savich.employeeManagement.dto.EmployeeDto;
import com.savich.employeeManagement.entity.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeMapperTest {

    EmployeeMapper employeeMapper;

    @BeforeEach
    void init() {
        employeeMapper = new EmployeeMapper();
    }

    @Test
    void shouldMapEmployeeWhenCallMapToEmployeeMethod() {
        EmployeeDto employeeDto=new EmployeeDto();
        employeeDto.setFirstName("John");
        employeeDto.setLastName("Saylor");
        employeeDto.setDepartmentId(3);
        employeeDto.setJobTitle("worker");
        employeeDto.setGender("m");
        Employee employee = employeeMapper.mapToEmployee(employeeDto);
        assertThat(employee.getDepartmentId()).isEqualTo(3);
        assertThat(employee.getFirstName()).isEqualTo("John");
        assertThat(employee.getLastName()).isEqualTo("Saylor");
        assertThat(employee.getJobTitle()).isEqualTo("worker");
        assertThat(employee.getGender()).isEqualTo("m");
    }
}