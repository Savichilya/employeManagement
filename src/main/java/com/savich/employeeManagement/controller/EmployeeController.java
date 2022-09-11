package com.savich.employeeManagement.controller;

import com.savich.employeeManagement.dto.EmployeeDto;
import com.savich.employeeManagement.entity.Employee;
import com.savich.employeeManagement.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/save")
    public Employee saveEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.saveEmployee(employeeDto);
    }

    @PutMapping("/update/{id}")
    public void updateEmployee(@PathVariable(value = "id") int id, @RequestBody EmployeeDto employeeDto) {
        employeeService.updateEmployee(id, employeeDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable(value = "id") int id) {
        employeeService.deleteEmployeeById(id);
    }

    @GetMapping("/get/{id}")
    public Employee getEmployee(@PathVariable(value = "id") int id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

}


