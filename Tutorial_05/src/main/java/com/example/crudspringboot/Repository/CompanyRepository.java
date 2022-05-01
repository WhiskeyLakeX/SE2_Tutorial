package com.example.crudspringboot.Repository;

import com.example.crudspringboot.Model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    @Override
    Company getById(Long aLong);
    Long countById(Long id);

}
