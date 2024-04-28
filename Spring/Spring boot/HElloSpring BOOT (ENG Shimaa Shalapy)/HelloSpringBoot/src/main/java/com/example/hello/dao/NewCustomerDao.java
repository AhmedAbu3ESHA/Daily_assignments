package com.example.hello.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.hello.entities.Customer;

public interface NewCustomerDao extends JpaRepository<Customer, Integer> {
	
	public Customer findByFirstName(String fName);
	public Customer findByFirstNameOrLastName(String fName,String lName);
	
	@Query("from Customer c Where c.firstName LIKE ?1")
	public List<Customer> findCustomersLikeName(String name);
	
	
	

}
