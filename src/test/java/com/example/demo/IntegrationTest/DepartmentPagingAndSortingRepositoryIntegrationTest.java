package com.example.demo.IntegrationTest;

import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DepartmentPagingAndSortingRepositoryIntegrationTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    public void givenDbContainsDepartments_whenFindDepartmentsByDepartmentId_thenReturnDepartmentsByDepartmentId() {
        Department dep1 = new Department(1L, "ETC1", "A-Block", "EC-01");
        Department dep2 = new Department(2L, "ETC2", "B-Block", "EC-02");
        Department dep3 = new Department(3L, "ETC3", "C-Block", "EC-03");
        departmentRepository.saveAll(Arrays.asList(dep1, dep2, dep3));

        Pageable pageable = PageRequest.of(0, 3, Sort.by("departmentId").descending());
        List<Department> departments = departmentRepository.findDepartmentsByDepartmentId(3L, pageable);
        assertEquals(1, departments.size());
        assertEquals(dep3.getDepartmentId(), departments.get(0).getDepartmentId());
    }

}
