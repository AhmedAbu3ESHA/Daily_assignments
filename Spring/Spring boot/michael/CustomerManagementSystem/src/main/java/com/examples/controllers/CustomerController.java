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

import java.util.List;

@RequestMapping("/customer")
@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @RequestMapping("list")
    public String listAllCustomers(Model model){
        List<Customer> customers = this.customerService.getAllCustomer();
        model.addAttribute("customersList",customers);
        return "list-customers";
    }

    @RequestMapping("/add")
    public String showAddCustomerForm(Model model){
        model.addAttribute("theCustomer",new Customer());
        return "add-customer";
    }

    @RequestMapping("/process-add-customer")
    public String processAddCustomer(@ModelAttribute("theCustomer") Customer c,Model model){
        if(c.getId() == 0){
            customerService.insertCustomer(c);
        } else {
            customerService.updateCustomer(c);
        }
        return this.listAllCustomers(model);
    }

    @RequestMapping("/delete")
    public String deleteCustomerById(@RequestParam("id") int id,Model model){
        this.customerService.deleteCustomer(id);
        return listAllCustomers(model);
    }

    @RequestMapping("/update/{id}")
    public String showUpdateCustomerForm(@PathVariable int id,Model model){
        Customer c = this.customerService.getCustomerById(id);
        model.addAttribute("theCustomer",c);
        return "add-customer";
    }


}
