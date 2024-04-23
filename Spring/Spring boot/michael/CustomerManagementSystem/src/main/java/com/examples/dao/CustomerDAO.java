package com.examples.dao;

import com.examples.entities.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CustomerDAO {
    @Autowired
    SessionFactory sessionFactory;
    //insert customer
    @Transactional
    public void insertCustomer(Customer c){
        Session session = sessionFactory.getCurrentSession();
        session.save(c);
    }

    //get all customers
    @Transactional
    public List<Customer> getAllCustomer(){
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Customer",Customer.class).getResultList();
    }


    //get customer by id
    @Transactional
    public Customer getCustomerById(int id){
        Session session = sessionFactory.getCurrentSession();
        return session.get(Customer.class,id);
    }

    //update customer
    @Transactional
    public void updateCustomer(Customer c){
        Session session = sessionFactory.getCurrentSession();
        session.update(c);
    }

    //delete customer
    @Transactional
    public void deleteCustomer(int id){
        Session session = sessionFactory.getCurrentSession();
        Customer c = getCustomerById(id);
        session.delete(c);
    }



}
