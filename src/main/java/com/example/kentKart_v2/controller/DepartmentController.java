package com.example.kentKart_v2.controller;

import com.example.kentKart_v2.dto.DepartmentDto;
import com.example.kentKart_v2.entity.Department;
import com.example.kentKart_v2.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    // POST
    // Saves a Department
    @PostMapping("/add-department")
    public Department saveDepartment(@RequestBody DepartmentDto department) {
        log.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    // GET
    // Finds a Department by ID
    @GetMapping("/{id}")
    public Department findDepartmentByDepartmentId(@PathVariable("id") Long departmentId) {
        log.info("Inside findDepartmentByDepartmentId of DepartmentController");
        return departmentService.findDepartmentByDepartmentId(departmentId);
    }

    // PUT
    // Updates a Department
    @PutMapping("/{id}")
    public Department updateDepartmentByDepartmentId(@PathVariable("id") Long departmentId, @RequestBody DepartmentDto department) {
        log.info("Inside updateDepartmentByDepartmentId of DepartmentController");
        return departmentService.updateDepartmentByDepartmentId(departmentId, department);
    }

    // DELETE
    // Deletes a Department
    @DeleteMapping("/{id}")
    public void deleteDepartmentByDepartmentId(@PathVariable("id") Long departmentId) {
        log.info("Inside deleteDepartmentByDepartmentId of DepartmentController");
        departmentService.deleteDepartmentByDepartmentId(departmentId);
    }

}
