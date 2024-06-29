package com.example.demo.service;

import com.example.demo.entity.Department;
import org.springframework.http.ResponseEntity;

public interface DepartmentService {

    // Save operation
    Department saveDepartment(Department department);

    // Read operation
    Iterable<Department> fetchDepartmentList();

    ResponseEntity<Department> findById(Long id);

    ResponseEntity<Department> findByDepartmentName(String departmentName);

    // Update operation
    Department updateDepartment(Department department);

    // Patch update operation
    Department patchUpdateDepartment(Department department, Long departmendId);

    // Delete operation
    void deleteDepartmentById(Long departmentId);

}
