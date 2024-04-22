package com.examples.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.examples.entites.Customer;

@Repository
public class CustomerDAO {
//DAO operations
    @Autowired
	SessionFactory sessionFactory;
	
	// insert new customer
	@Transactional
	public void insertCustomer(Customer c) {
		Session session=sessionFactory.getCurrentSession();
		session.save(c);
		
	}
	
	//get all customer

	@Transactional
	public List<Customer> getCustomer() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Customer> CustomerList = session.createCriteria(Customer.class).list();
		 CustomerList.stream().forEach(i->System.out.println(i));
		return CustomerList;
	}
	//get customer by id
	
	//insert customer
	
	//delete customer 
	
	//update customer
	
	
}
