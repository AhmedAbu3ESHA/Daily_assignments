package com.examples.services;

import com.examples.dao.CustomerDAO;
import com.examples.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerDAO customerDAO;

    //insert new customer
    public void insertCustomer(Customer c){
        this.customerDAO.insertCustomer(c);
    }

    //get customer by id
    public Customer showCustomer(int id){
       return this.customerDAO.getCustomerById(id);
    }

    //delete customer
    public void deleteCustomer(int id){
        this.customerDAO.deleteCustomer(id);
    }

    public void updateCustomer(Customer c){
        this.customerDAO.updateCustomer(c);
    }

    //get customer by id
    public Customer getCustomerById(int id){
        return this.customerDAO.getCustomerById(id);
    }

   //get all customers
    public List<Customer> getAllCustomer(){
        return this.customerDAO.getAllCustomer();
    }

}
