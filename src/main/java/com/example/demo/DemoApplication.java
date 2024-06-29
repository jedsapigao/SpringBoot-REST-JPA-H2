package com.example.demo;

import com.example.demo.entity.Department;

import com.example.demo.repository.DepartmentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(DepartmentRepository departmentRepo) {
		return args -> {
			departmentRepo.save(new Department(1L, "ETC1", "A-Block", "EC-01"));
			departmentRepo.save(new Department(2L, "ETC2", "B-Block", "EC-02"));
			departmentRepo.save(new Department(3L, "ETC3", "C-Block", "EC-03"));
			departmentRepo.save(new Department(4L, "ETC4", "D-Block", "EC-04"));
			departmentRepo.save(new Department(5L, "ETC5", "E-Block", "EC-05"));
			departmentRepo.save(new Department(6L, "ETC6", "F-Block", "EC-06"));

		};
	}

}
