package com.examples.services;

import java.util.List;

import javax.transaction.Transactional;

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
	
	  public Customer getCustomer(int id) {
	        return this.customerDAO.getcustomer(id);
	    }
	
	 
    public void updateCustomer(Customer customer) {
    	this.customerDAO.updateCustomer(customer);
 
    }
 
   
    public void deleteCustomer(int id) {
    	this.customerDAO.deleteCustomer(id);
    }
	
	
	
}