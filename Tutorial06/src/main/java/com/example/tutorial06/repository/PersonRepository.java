package com.example.tutorial06.repository;

import com.example.tutorial06.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
