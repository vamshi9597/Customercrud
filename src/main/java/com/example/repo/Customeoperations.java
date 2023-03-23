package com.example.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Customer;

public interface Customeoperations extends CrudRepository<Customer, Integer> {

}
