package com.example.tutorial06.controller;

import com.example.tutorial06.entity.Person;
import com.example.tutorial06.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    @Autowired //refer to repository
    PersonRepository personRepository;

    @GetMapping(value = "/") //because it's GET method
    public List<Person> viewAllPerson() {
        List<Person> personList = personRepository.findAll();
        return personList;
    }

    @GetMapping(value = "/{id}")
    public Person viewPersonbyId(
            @PathVariable(value = "id") Long id
    ){
        Person person = personRepository.findById(id);
        return person;
    }

    @DeleteMapping(value = "/{id}")
    public String deletePerson(
            @PathVariable(value = "id") Long id
    ) {
        if (personRepository.existsById(id)) {
            Person person = personRepository.getById(id);
            personRepository.delete(person);
            return "Delete success";
        } else {
            return "Delete faild";
        }
    }

    @PostMapping(value = "/")
    public Person addPerson(
            @RequestBody Person person
    ) {
        return personRepository.save(person);
    }

    @PutMapping(value = "/{id}")
    public void updatePerson(
        @RequestBody Person person,
        @PathVariable(value="id") Long id
    ) {
        if (personRepository.existsById(id)) {
            person.setId(id);
            personRepository.save(person);
        }
    }
}
