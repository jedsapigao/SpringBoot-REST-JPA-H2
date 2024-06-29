package com.example.demo.controller;

import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api/school", produces="application/json")
public class DepartmentController {

    @Autowired
    private DepartmentServiceImpl departmentServiceImpl;

    // Save operation
    @PostMapping(path = "/departments", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Department saveDepartment(@Valid @RequestBody Department department) {
        return departmentServiceImpl.saveDepartment(department);
    }

    // Read operation
    @GetMapping(params="recent")
    public Iterable<Department> fetchDepartmentList() {
        return departmentServiceImpl.fetchDepartmentList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> fetchDepartmentById(@PathVariable("id") Long id) {
        return departmentServiceImpl.findById(id);
    }

    @GetMapping("/requestParam")
    public ResponseEntity<Department> fetchDepartmentById(@RequestParam("departmentName") String departmentName) {
        return departmentServiceImpl.findByDepartmentName(departmentName);
    }

    // Update operation
    @PutMapping(path="/departments/{id}", consumes = "application/json")
    public Department updateDepartment(@PathVariable("id") Long departmentId,
                     @RequestBody Department department) {
        department.setDepartmentId(departmentId);
        return departmentServiceImpl.updateDepartment(department);
    }

    // Update operation
    @PatchMapping(path="/departments/{id}", consumes = "application/json")
    public Department patchUpdateDepartment(@PathVariable("id") Long departmentId,
                     @RequestBody Department department) {
        return departmentServiceImpl.patchUpdateDepartment(department, departmentId);
    }

    // Delete operation
    @DeleteMapping("/departments/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDepartmentById(@PathVariable("id") Long departmentId) {
        try {
            departmentServiceImpl.deleteDepartmentById(departmentId);
        } catch (EmptyResultDataAccessException e) {
        }
    }

}
