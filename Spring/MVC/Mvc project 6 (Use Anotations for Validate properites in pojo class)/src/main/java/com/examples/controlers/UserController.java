package com.examples.controlers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("/login")
	public String showLoginForm() {
		return "login";
		
	}
	
	@RequestMapping("/confirm")
	public String submitLoginForm(@RequestParam("userName") String userName,
			                      @RequestParam("age") int age  ,Model model) {
		
//		System.out.println("Username"+ userName);
		
		model.addAttribute("ConfirmationMSG","heloo" + userName );
		
		model.addAttribute("ConfirmationMSGage","you will be " + (age+5) + " at 2029 ");
		
		
		return "confirmation";
			
	}
	
	
}
