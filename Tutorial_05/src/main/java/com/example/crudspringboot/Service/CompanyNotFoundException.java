package com.example.crudspringboot.Service;

public class CompanyNotFoundException extends Throwable {
    public CompanyNotFoundException(String message) {
        super(message);
    }
}
