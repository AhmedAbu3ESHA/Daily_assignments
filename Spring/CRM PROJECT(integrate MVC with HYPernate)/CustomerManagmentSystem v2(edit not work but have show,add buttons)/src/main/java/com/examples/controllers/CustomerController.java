package com.examples.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.examples.entites.Customer;
import com.examples.services.CustomerServices;

@Controller
public class CustomerController {

	@Autowired
	private CustomerServices customerService;
	
	@RequestMapping("/addcustomer")
	public String showAddCustomerForm(Model model) 
	{
		model.addAttribute("customer",new Customer());
		return "add-customer";
	}
	
	@RequestMapping("/processaddcustomer")
	public String showAddCustomerForm(@ModelAttribute("customer") Customer c ,Model model) 
	{
		customerService.insertCustomer(c);
		List listOfCustomers = customerService.getCustomer();
		   model.addAttribute("customer", new Customer());
		model.addAttribute("CustomerList", listOfCustomers);
		return "add-customer";
	}

	
	@RequestMapping("/processgetcustomer")
	public String showGetCustomerForm(Model model ) 
	{
		List listOfCustomers = customerService.getCustomer();
	    model.addAttribute("customer", new Customer());
		model.addAttribute("CustomerList", listOfCustomers);
		
		return "add-customer";
	}
	
	
    @RequestMapping(value = "/updateCustomer/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public String updateCustomer(@PathVariable("id") int id,Model model) {
        model.addAttribute("customer", this.customerService.getCustomer(id));
        model.addAttribute("CustomerList", this.customerService.getCustomer());
        return "add-customer";
    }
 
    @RequestMapping(value = "/deleteCustomer/{id}")
    public String deleteCountry(@PathVariable("id") int id) {
    	customerService.deleteCustomer(id);
        return "redirect:/processgetcustomer";
 
    }

	
}
