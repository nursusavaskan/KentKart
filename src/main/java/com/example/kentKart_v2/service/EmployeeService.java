package com.example.kentKart_v2.service;

import com.example.kentKart_v2.dto.EmployeeDto;
import com.example.kentKart_v2.entity.Employee;
import com.example.kentKart_v2.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    // POST
    // Saves an Employee
    public Employee saveEmployee(EmployeeDto employeeDto
    ) {
        log.info("Inside saveEmployee of EmployeeService");
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        return employeeRepository.save(employee);
    }

    // GET
    // Finds an Employee by ID
    public Employee findEmployeeByEmployeeId(Long employeeId) {
        log.info("Inside findEmployeeByEmployeeId of EmployeeService");
        return employeeRepository.findByEmployeeId(employeeId);
    }

    // PUT
    // Updates an Employee
    public Employee updateEmployeeByEmployeeId(Long employeeId, EmployeeDto employeeDto
    ) {
        log.info("Inside updateEmployeeByEmployeeId of EmployeeService");
        Employee employee = new Employee();
        // Dto to Entity
        BeanUtils.copyProperties(employeeDto, employee);
        Employee u = employeeRepository.findByEmployeeId(employeeId);
        u.setName(employee.getName());
        return employeeRepository.save(u);
    }

    // DELETE
    // Deletes an Employee
    public void deleteEmployeeByEmployeeId(Long employeeId) {
        log.info("Inside deleteEmployeeByEmployeeId of EmployeeService");
        Employee employee = employeeRepository.findByEmployeeId(employeeId);
        employeeRepository.delete(employee);
    }
}
