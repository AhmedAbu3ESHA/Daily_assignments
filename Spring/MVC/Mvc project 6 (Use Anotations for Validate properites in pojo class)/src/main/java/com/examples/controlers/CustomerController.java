package com.examples.controlers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	public String processAddCustomer(@Valid @ModelAttribute("theCustomer") Customer c ,BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "add-customer";
		}
		
		else 
		{
		System.out.println(c);
		return "addCustomerConfirmation";
		}
		
	}

}

