package com.example.tutorial03_se2.controller;

import com.example.tutorial03_se2.entity.Employee;
import com.example.tutorial03_se2.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;
    @RequestMapping(value = "/")
    public String viewAllEmployee(Model model) {
        //get data from table Employee in db
        List<Employee> employees = employeeRepository.findAll();
        //send this data to front-end (view)
        model.addAttribute("employees", employees);
        //render view
        return "employeeList";
    }
    @RequestMapping(value="/{id}")
    public String getEmployeeById(
            @PathVariable(value = "id") Long id, Model model) {
        Employee employee = employeeRepository.getById(id);
        model.addAttribute("employee", employee);
        return "employeeDetails";
    }
    @RequestMapping(value="/update/{id}")
    public String updateEmployee(
            @PathVariable (value="id") Long id, Model model) {
        Employee employee = employeeRepository.getById(id);
        model.addAttribute(employee);
        return "employeeUpdate";
    }
    @RequestMapping(value = "/save")
    public String saveUpdate(
            @RequestParam(value = "id", required = false) Long id, Employee employee
    ) {
        employee.setId(id);
        employeeRepository.save(employee);
        return "redirect:/";
    }
    @RequestMapping(value = "delete/{id}")
    public String deleteEmployee(
            @PathVariable(value = "id") Long id) {
        Employee employee = employeeRepository.getById(id);
        employeeRepository.delete(employee);
        return "redirect:/";
    }
    @RequestMapping(value = "/add")
    public String addEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employeeAdd";
    }
}
