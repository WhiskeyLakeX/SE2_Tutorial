package com.example.tutorial03_se2.repository;

import com.example.tutorial03_se2.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
