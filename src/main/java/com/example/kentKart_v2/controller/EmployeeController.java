package com.example.kentKart_v2.controller;

import com.example.kentKart_v2.dto.EmployeeDto;
import com.example.kentKart_v2.entity.Employee;
import com.example.kentKart_v2.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
@Slf4j
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    // POST
    // Saves an Employee
    @PostMapping("/add-employee")
    public Employee saveEmployee(@RequestBody EmployeeDto employee) {
        log.info("Inside saveEmployee of EmployeeController");
        return employeeService.saveEmployee(employee);
    }

    // GET
    // Finds a Employee by ID
    @GetMapping("/{id}")
    public Employee findEmployeeByEmployeeId(@PathVariable("id") Long employeeId) {
        log.info("Inside findEmployeeByEmployeeId of EmployeeController");
        return employeeService.findEmployeeByEmployeeId(employeeId);
    }

    // PUT
    // Updates a Employee
    @PutMapping("/{id}")
    public Employee updateEmployeeByEmployeeId(@PathVariable("id") Long employeeId, @RequestBody EmployeeDto employee) {
        log.info("Inside updateEmployeeByEmployeeId of EmployeeController");
        return employeeService.updateEmployeeByEmployeeId(employeeId, employee);
    }

    // DELETE
    // Deletes a Employee
    @DeleteMapping("/{id}")
    public void deleteEmployeeByEmployeeId(@PathVariable("id") Long employeeId) {
        log.info("Inside deleteEmployeeByEmployeeId of EmployeeController");
        employeeService.deleteEmployeeByEmployeeId(employeeId);
    }
    }

