package com.example.kentKart_v2.service;

import com.example.kentKart_v2.dto.DepartmentDto;
import com.example.kentKart_v2.entity.Department;
import com.example.kentKart_v2.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    // POST
    // Saves a Department
    public Department saveDepartment(DepartmentDto departmentDto) {
        log.info("Inside saveDepartment of DepartmentService");
        Department department = new Department();
        BeanUtils.copyProperties(departmentDto, department);
        return departmentRepository.save(department);
    }

    // GET
    // Finds a Department by ID
    public Department findDepartmentByDepartmentId(Long departmentId) {
        log.info("Inside findDepartmentByDepartmentId of DepartmentService");
        return departmentRepository.findByDepartmentId(departmentId);
    }

    // PUT
    // Updates a Department
    public Department updateDepartmentByDepartmentId(Long departmentId, DepartmentDto departmentDto) {
        log.info("Inside updateDepartmentByDepartmentId of DepartmentService");
        Department department = new Department();
        // Dto to Entity
        BeanUtils.copyProperties(departmentDto, department);
        Department u = departmentRepository.findByDepartmentId(departmentId);
        u.setDepartmentName(department.getDepartmentName());
        return departmentRepository.save(u);
    }

    // DELETE
    // Deletes a Department
    public void deleteDepartmentByDepartmentId(Long departmentId) {
        log.info("Inside deleteDepartmentByDepartmentId of DepartmentService");
        Department department = departmentRepository.findByDepartmentId(departmentId);
        departmentRepository.delete(department);
    }
}
