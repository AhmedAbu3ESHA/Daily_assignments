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
	public Customer insertCustomer(Customer c) {
		Session session=sessionFactory.getCurrentSession();
		session.persist(c);
		return c;
	}
	
	//get all customer

	@Transactional
	public List<Customer> getCustomer() {
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Customer> CustomerList = session.createQuery("from Customer").list();
				//session.createCriteria(Customer.class).list();
		 //CustomerList.stream().forEach(i->System.out.println(i));
		return CustomerList;
		 
	}
	//get customer by id
	   @Transactional
	   public Customer getcustomer(int id) {
	        Session session = this.sessionFactory.getCurrentSession();
	        Customer customer = (Customer) session.load(Customer.class, new Integer(id));
	        return customer;
	    }
	
	//update customer
	@Transactional
    public void updateCustomer(Customer customer) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(customer);
    }
  //delete customer
	@Transactional
	public void deleteCustomer(int id) {
        Session session = this.sessionFactory.getCurrentSession();
       Customer p = (Customer) session.load(Customer.class, new Integer(id));
        if (null != p) {
            session.delete(p);
        }
    }
	
}
