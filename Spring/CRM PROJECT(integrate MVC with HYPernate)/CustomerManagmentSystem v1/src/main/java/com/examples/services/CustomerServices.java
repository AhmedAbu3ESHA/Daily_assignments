package com.examples.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examples.dao.CustomerDAO;
import com.examples.entites.Customer;

@Service
public class CustomerServices {

	@Autowired
	private CustomerDAO  customerDAO ;
	
	public void insertCustomer(Customer c) {
		this.customerDAO.insertCustomer(c);
	}
	
	
	public List<Customer> getCustomer() {
		return this.customerDAO.getCustomer();
	}
	
	
	
	
	
}
