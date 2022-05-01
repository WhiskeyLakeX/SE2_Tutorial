package com.example.crudspringboot.Service;

import com.example.crudspringboot.Model.Company;
import com.example.crudspringboot.Repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    public List<Company> listAll() {
        return (List<Company>) companyRepository.findAll();
    }

    public void save(Company company) {
        companyRepository.save(company);
    }

    public Company get(Long id) throws CompanyNotFoundException {
        Optional<Company> result = companyRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new CompanyNotFoundException("Could not find any company with ID :" + id);
    }

    public void delete(Long id) throws CompanyNotFoundException {
        Long count = companyRepository.countById(id);
        if (count == null || count == 0) {
            throw new CompanyNotFoundException("Could not find any company with ID :" + id);
        }
        companyRepository.deleteById(id);
    }
}
