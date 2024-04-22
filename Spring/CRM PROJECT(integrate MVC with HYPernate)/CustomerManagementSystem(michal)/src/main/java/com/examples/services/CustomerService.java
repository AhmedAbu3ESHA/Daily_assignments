package com.examples.services;

import com.examples.dao.CustomerDAO;
import com.examples.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerDAO customerDAO;
    public void insertCustomer(Customer c){
        this.customerDAO.insertCustomer(c);
    }

    public Customer showCustomer(int id){
       return this.customerDAO.getCustomerById(id);
    }


}
