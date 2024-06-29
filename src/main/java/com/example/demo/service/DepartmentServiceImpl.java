package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.repository.DepartmentRepository;
import com.example.demo.entity.Department;

import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    private static final org.slf4j.Logger log =
            org.slf4j.LoggerFactory.getLogger(DepartmentServiceImpl.class);

    // Save operation
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    // Read operation
    @Override public Iterable<Department> fetchDepartmentList() {
        PageRequest page = PageRequest.of(0, 3, Sort.by("departmentId").descending());
        return departmentRepository.findAll(page).getContent();
    }

    @Override
    public ResponseEntity<Department> findById(Long id) {
        Optional<Department> department = departmentRepository.findById(id);
        if(department.isPresent()) {
            ResponseEntity<Department> responseEntity = new ResponseEntity<>(department.get(), HttpStatus.OK);
            log.info("Fetched time: {} ", responseEntity.getHeaders().getDate());
            return responseEntity;
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Department> findByDepartmentName(String departmentName) {
        Optional<Department> department = departmentRepository.findByDepartmentName(departmentName);
        if(department.isPresent()) {
            ResponseEntity<Department> responseEntity = new ResponseEntity<>(department.get(), HttpStatus.OK);
            log.info("Fetched time: {} ", responseEntity.getHeaders().getDate());
            return responseEntity;
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    // Update operation
    @Override
    public Department updateDepartment(Department department) {
        return departmentRepository.save(department);
    }

    // Patch update operation
    @Override
    public Department patchUpdateDepartment(Department department, Long departmentId) {
        Department depDB = departmentRepository.findById(departmentId).get();
        if (department.getDepartmentName() != null) {
            depDB.setDepartmentName(department.getDepartmentName());
        }
        if (department.getDepartmentAddress() != null) {
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }
        return departmentRepository.save(depDB);
    }

    // Delete operation
    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

}
