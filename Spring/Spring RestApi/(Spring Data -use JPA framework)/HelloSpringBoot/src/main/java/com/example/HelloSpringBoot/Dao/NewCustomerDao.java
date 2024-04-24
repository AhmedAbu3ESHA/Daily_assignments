package com.example.HelloSpringBoot.Dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.HelloSpringBoot.Entites.Customer;

public interface NewCustomerDao extends JpaRepository <Customer,Integer> {

	// searching using first  name
	public Customer findByFirstName(String fName);

	public Customer findByFirstNameOrLastName(String fname, String lname);


	@Query("from Customer c Where c.firstName LIKE ?1")
	public List<Customer> findCustomersLikeName(String name);
}
