package com.example.hello.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hello.dao.NewCustomerDao;
import com.example.hello.entities.Customer;

@RestController
@RequestMapping("/customers")
public class CustomerRestController {
	
//	@Autowired
//	private CustomerDao dao;
//	
	
	@Autowired
	private NewCustomerDao dao;
	
	@GetMapping("/{id}")
	public Customer getCustomerById(@PathVariable int id) {
		return dao.findById(id).get();
	}
	
	@GetMapping
	public List<Customer> getCustomers() {
		return dao.findAll();
	}
	
	@GetMapping("/name/{name}")
	public Customer getCustomerByName(@PathVariable String name) {
		return dao.findByFirstName(name);
	}
	
	@GetMapping("/name/{fName}/{lName}")
	public Customer getCustomerByFirstNameOrLastName(@PathVariable String fName,@PathVariable String lName) {
		return dao.findByFirstNameOrLastName(fName,lName);
	}
	
	@GetMapping("/name/like/{name}")
	public List<Customer> getCustomerByLikeName(@PathVariable String name) {
		return dao.findCustomersLikeName(name);
	}

}
