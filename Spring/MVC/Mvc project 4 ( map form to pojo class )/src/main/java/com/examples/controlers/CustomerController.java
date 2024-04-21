package com.examples.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.pojo.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@RequestMapping("/add")
	public String showAddCustomerForm(Model model) {
		model.addAttribute("theCustomer",new Customer());
		return "add-customer";
		
	}
	
	@RequestMapping("/addCustomerSucsses")
	public String processAddCustomer(@ModelAttribute("theCustomer") Customer c) {
		System.out.println(c);
		return "addCustomerConfirmation";
		
	}

}

