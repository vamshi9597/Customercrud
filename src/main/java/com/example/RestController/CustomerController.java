package com.example.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Customer;
import com.example.service.CustomerService;

@RestController
public class CustomerController {
@Autowired
	CustomerService csservice;
	@GetMapping("/Customers")
	
public List <Customer> getallcustomer(){
		return csservice.getallcustomers();
		
	} 
	@GetMapping("/Customers/{custid}")
	public Customer getcustomer(@PathVariable("custid")int custid) {
		return csservice.getallcustomers().get(custid);
		
	}
	
	@PostMapping("/customer")
	private Customer savecustomer(@RequestBody Customer scr) {
		return csservice.savecustomer(scr);
	}
	@PutMapping("/customer")
	private Customer updatecust(@RequestBody Customer scr){
		 csservice.saveandupdate(scr);
		 return scr;
	}
	@DeleteMapping("/customer/{custid}")
	public void deletecustomer(@PathVariable ("custid")int custid) {
		csservice.delete(custid);
	}
}
