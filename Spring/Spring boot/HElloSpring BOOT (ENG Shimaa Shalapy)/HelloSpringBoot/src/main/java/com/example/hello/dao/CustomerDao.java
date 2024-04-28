package com.example.hello.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.hello.entities.Customer;

import jakarta.persistence.EntityManager;

@Repository
public class CustomerDao {
	
	@Autowired
	private EntityManager em;
	
	public Customer getCustomerById(int id) {
		return em.find(Customer.class, id);
	}

}
