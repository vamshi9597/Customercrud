package com.example.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Customer;
import com.example.repo.Customeoperations;

import java.util.List;

import javax.persistence.EntityNotFoundException;

@Service
public class CustomerService {
	@Autowired
	Customeoperations csoperations;
	
	
	public List <Customer> getallcustomers(){
	 List<Customer> ls=new ArrayList<Customer>();
	csoperations.findAll().forEach(customers->ls.add(customers));
	return ls;
			
		}
	public Customer savecustomer(Customer cs) {
		return csoperations.save(cs);
	}
	public Customer saveandupdate(Customer cs)  {
		if(csoperations.existsById(cs.getId())) {
		return csoperations.save(cs);
		}else {
			throw new EntityNotFoundException("customer with id"+cs.getId());
		}
	
	}
	public void delete(int id) {
		csoperations.deleteById(id);
	}
			

}
