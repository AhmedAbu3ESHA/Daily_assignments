package com.examples.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	
	@RequestMapping("/hello")
	public String sayHello() {
		return "hello-user";
			
	}
	
}
