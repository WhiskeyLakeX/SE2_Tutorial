package com.example.crudspringboot.Controller;

import com.example.crudspringboot.Model.Company;
import com.example.crudspringboot.Model.Employee;
import com.example.crudspringboot.Service.CompanyNotFoundException;
import com.example.crudspringboot.Service.CompanyService;
import com.example.crudspringboot.Service.EmployeeNotFoundException;
import com.example.crudspringboot.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CompanyController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CompanyService companyService;

//    @RequestMapping(value = "/{id}")
//    public String getCompanyById(@PathVariable(value = "id")Long id, Model model) {
//
//    }
    @GetMapping("/companies")
    public String showCompanyList(Model model) {
        List<Company> listCompany = companyService.listAll();
        model.addAttribute("listCompanies", listCompany);
        return "companies";
    }

    @PostMapping("/companies/save")
    public String saveEmployees(Company company, RedirectAttributes redirectAttributes) {
        companyService.save(company);
        redirectAttributes.addFlashAttribute("message","The employee has been saved successfully.");
        return "redirect:/companies";
    }

    @GetMapping("/companies/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes) {
        try {
            Company company = companyService.get(id);
            model.addAttribute("company", company);
            model.addAttribute("pageTitle","Edit Company (ID: " + id + ")");
            redirectAttributes.addFlashAttribute("message","The company with ID: " + id + "has been updated successfully.");
            return "company_form";
        } catch (CompanyNotFoundException e) {
            redirectAttributes.addFlashAttribute("message",e.getMessage());
            return "redirect:/companies";
        }
    }

    @GetMapping("/companies/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            employeeService.delete(id);
            redirectAttributes.addFlashAttribute("message", "The company with ID: " + id + " has been deleted successfully.");
        } catch (EmployeeNotFoundException e) {
            redirectAttributes.addFlashAttribute("message",e.getMessage());
        }
        return "redirect:/companies";
    }
}
