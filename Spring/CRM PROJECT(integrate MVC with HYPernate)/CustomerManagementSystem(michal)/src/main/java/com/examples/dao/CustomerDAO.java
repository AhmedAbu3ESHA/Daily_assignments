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
//    public void getAllCustomer(Customer c){
//        Session session = sessionFactory.getCurrentSession();
//        List<Customer> customers = session.createQuery("from Customer i" , Customer.class)
//                .getResultList();
//        customers.stream().forEach(i -> System.out.println(i));
//    }


//    get customer by id
    public Customer getCustomerById(int id){
        Session session = sessionFactory.getCurrentSession();
        Customer customer = session.get(Customer.class,id);
        return customer;
    }

    //update customer
//    public void updateCustomer(Customer c){
//        Session session = sessionFactory.getCurrentSession();
//        Customer customer= session.get(Customer.class,1);
//        customer.setFirstName("Ahmed");
//        customer.setLastName("Mosutafa");
//        customer.setEmail("ahmed.mustafa@gmail.com");
//        session.save(c);
//    }

    //delete customer
//    public void deleteCustomer(Customer c){
//        Session session = sessionFactory.getCurrentSession();
//        Customer customer= session.get(Customer.class,1);
//        session.remove(customer);
//    }



}
