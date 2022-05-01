package com.example.crudspringboot.Repository;

import com.example.crudspringboot.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.*;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Long countById(Long id);
    List<Employee> findByNameContaining(String name);
}
