package com.example.crudspringboot.Service;

import com.example.crudspringboot.Model.Employee;
import com.example.crudspringboot.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> listAll() {
        return (List<Employee>) employeeRepository.findAll();
    }

    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    public Employee get(Long id) throws EmployeeNotFoundException{
        Optional<Employee> result = employeeRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new EmployeeNotFoundException("Could not find any employee with ID: " + id);
    }

    public void delete(Long id) throws EmployeeNotFoundException {
        Long count = employeeRepository.countById(id);
        if (count == null || count == 0) {
            throw new EmployeeNotFoundException("Could not find any employee with ID: " + id);
        }
        employeeRepository.deleteById(id);
    }

    public List<Employee> findByNameContaining(String name){
        return (List<Employee>) employeeRepository.findByNameContaining(name);
    }

    public List<Employee> ascSort() {
        List<Employee> employees = employeeRepository.findAll(Sort.by(Sort.Direction.ASC,"name"));
        return employees;
    }

    public List<Employee> descSort() {
        List<Employee> employees = employeeRepository.findAll(Sort.by(Sort.Direction.DESC,"name"));
        return employees;
    }
}
