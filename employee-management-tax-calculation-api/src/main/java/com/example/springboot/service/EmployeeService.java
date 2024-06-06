package com.example.springboot.service;

import com.example.springboot.entity.Employee;

import java.time.LocalDate;
import java.util.List;


public interface EmployeeService {

    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    double calculateTax(double yearlySalary);
    double calculateCess(double yearlySalary);
    double calculateTotalSalary(double monthlySalary, LocalDate doj);

}
