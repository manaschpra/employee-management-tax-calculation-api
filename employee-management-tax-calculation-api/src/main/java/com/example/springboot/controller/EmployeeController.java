package com.example.springboot.controller;

import com.example.springboot.entity.Employee;
import com.example.springboot.response.EmployeeTaxResponse;
import com.example.springboot.service.EmployeeService;
import com.example.springboot.service.EmployeeServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody @Valid Employee employee) {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }


    @GetMapping("/{id}/tax")
    public ResponseEntity<?> getEmployeeTaxDetails(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id);

        double totalSalary = employeeService.calculateTotalSalary(employee.getSalary(), employee.getDoj());
        double yearlySalary = totalSalary * 12;
        double taxAmount = employeeService.calculateTax(yearlySalary);
        double cessAmount = employeeService.calculateCess(yearlySalary);



        return ResponseEntity.ok(new EmployeeTaxResponse(id, employee.getFirstName(), employee.getLastName(), yearlySalary, taxAmount, cessAmount));
    }


}

