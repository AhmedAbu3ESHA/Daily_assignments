package com.example.HelloSpringBoot.Rest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class HelloRestController {

	@GetMapping("/hello")
	public String sayHelloRestg() {
		
		return "hello get rest";
	}
	@PostMapping("/hello")
	public String sayHelloRestp() {
		
		return "hello post rest";
	}
	@DeleteMapping("/hello")
	public String sayHelloRestd() {
		
		return "hello delete rest";
	}

}
