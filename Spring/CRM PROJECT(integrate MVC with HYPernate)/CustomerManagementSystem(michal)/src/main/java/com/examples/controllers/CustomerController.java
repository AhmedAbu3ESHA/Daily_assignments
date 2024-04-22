package com.examples.controllers;

import com.examples.entities.Customer;
import com.examples.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@RequestMapping("/customer")
@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @RequestMapping("/add-customer")
    public String showAddCustomerForm(Model model){
        model.addAttribute("theCustomer",new Customer());
        return "add-customer";
    }

    @RequestMapping("/process-add-customer")
    public String processAddCustomer(@ModelAttribute("theCustomer") Customer c){
        customerService.insertCustomer(c);
        return "confirmation";
    }

    @RequestMapping("/process-show-customer/{id}")
    public String processShowCustomer(@PathVariable(value="id") int id, Model model){
     Customer customer=   customerService.showCustomer(id);
     model.addAttribute("customer",customer);
        return "customer-details";
    }



}
