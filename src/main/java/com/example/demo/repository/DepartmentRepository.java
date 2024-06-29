package com.example.demo.repository;

import com.example.demo.entity.Department;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends PagingAndSortingRepository<Department, Long>,
        ListCrudRepository<Department, Long> {
    List<Department> findDepartmentsByDepartmentId(Long departmentId, Pageable pageable);

    Optional<Department> findByDepartmentName(String departmentName);
}
