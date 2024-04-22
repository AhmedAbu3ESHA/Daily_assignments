package com.examples.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.examples.entites.Customer;
import com.examples.services.CustomerServices;
@RequestMapping("/Customers")
@Controller
public class GetCustomerDataController {

	@Autowired
	private  CustomerServices customerService;
	
	@RequestMapping("/getcustomer")
	public String showAddCustomerForm(Model model) 
	{
		model.addAttribute("GetTheCustomer",new Customer());
		return "get-customer";
	}
	
	@RequestMapping("/processgetcustomer")
	public String showGetCustomerForm(Model model ) 
	{
//		model.addAttribute("GetTheCustomer", new Customer());
		model.addAttribute("CustomerList", this.customerService.getCustomer());
		//List<Customer> CustomerList=customerService.getCustomer();
		return "get-customer";
	}
	
	
}
