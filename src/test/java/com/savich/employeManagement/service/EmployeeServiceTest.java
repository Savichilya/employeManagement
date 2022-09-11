package com.savich.employeManagement.service;

import com.savich.employeManagement.dao.EmployeeDao;
import com.savich.employeManagement.dto.EmployeeDto;
import com.savich.employeManagement.entity.Employee;
import com.savich.employeManagement.mapping.EmployeeMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class EmployeeServiceTest {

    EmployeeDao employeeDao;
    EmployeeService employeeService;
    EmployeeMapper employeeMapper;

    @BeforeEach
    void init() {
        employeeDao = Mockito.mock(EmployeeDao.class);
        employeeMapper = Mockito.mock(EmployeeMapper.class);
        employeeService = new EmployeeService(employeeDao, employeeMapper);
    }

    @Test
    void shouldSaveEmployeeWhenCallSaveMethod() {
        Employee employee = new Employee();
        EmployeeDto employeeDto = new EmployeeDto();
        employee.setFirstName("John");
        employee.setLastName("Black");
        employee.setDepartmentId(2);
        employee.setJobTitle("manager");
        employee.setGender("m");
        employeeDto.setFirstName("John");
        employeeDto.setLastName("Black");
        employeeDto.setDepartmentId(2);
        employeeDto.setJobTitle("manager");
        employeeDto.setGender("m");
        when(employeeMapper.mapToEmployee(employeeDto)).thenReturn(employee);
        when(employeeDao.save(employee)).thenReturn(employee);

        Employee resultSet = employeeService.saveEmployee(employeeDto);

        assertThat(resultSet).isEqualTo(employee);
    }

    @Test
    void shouldUpdateEmployeeWhenCallUpdateMethod() {
        Employee employee = new Employee();
        int id = 1;
        EmployeeDto employeeDto = new EmployeeDto();
        when(employeeMapper.mapToEmployee(employeeDto)).thenReturn(employee);

        employeeService.updateEmployee(id, employeeDto);

        verify(employeeDao).save(employeeMapper.mapToEmployee(employeeDto));
    }

    @Test
    void shouldReturnEmployeeWhenCallGetByIdMethod() {
        Employee employee = new Employee();
        int id = 1;
        when(employeeDao.findById(id)).thenReturn(Optional.of(employee));

        Employee resultEmployee = employeeService.getEmployeeById(id);

        assertThat(resultEmployee).isEqualTo(employee);
    }

    @Test
    void shouldReturnAllEmployeesWhenCallGetAllMethod() {
        List<Employee> employeeList = new ArrayList<>();
        when(employeeDao.findAll()).thenReturn(employeeList);

        List<Employee> resultList = employeeService.getAllEmployees();

        assertThat(resultList).isEqualTo(employeeList);
    }
}