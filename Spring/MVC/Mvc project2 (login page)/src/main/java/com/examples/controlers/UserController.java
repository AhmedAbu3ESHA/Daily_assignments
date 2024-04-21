package com.examples.controlers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("/login")
	public String showLoginForm() {
		return "login";
			
	}
	
	@RequestMapping("/confirm")
	public String submitLoginForm(HttpServletRequest request ,Model model) {
		
		String userName =request.getParameter("userName");
		
		System.out.println("Username"+ userName);
		
		model.addAttribute("ConfirmationMSG","heloo" + userName );
		
		return "confirmation";
			
	}
	
	
}
