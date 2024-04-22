package com.examples.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.examples.entites.Customer;
import com.examples.services.CustomerServices;

@Controller
public class CustomerController {

	@Autowired
	private CustomerServices customerService;
	
	@RequestMapping("/addcustomer")
	public String showAddCustomerForm(Model model) 
	{
		model.addAttribute("TheCustomer",new Customer());
		return "add-customer";
	}
	
	@RequestMapping("/processaddcustomer")
	public String showAddCustomerForm(@ModelAttribute("TheCustomer") Customer c ) 
	{
	
		customerService.insertCustomer(c);
		return "get-customer";
	}

	
}
