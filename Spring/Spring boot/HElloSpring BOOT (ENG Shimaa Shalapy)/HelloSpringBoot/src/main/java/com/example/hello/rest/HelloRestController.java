package com.example.hello.rest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class HelloRestController {
	
	@GetMapping("/hello")
	public String sayHelloRestForGet() {
		return "hello rest webservice from get handler";
	}
	@PostMapping("/hello")
	public String sayHelloRestforPost() {
		return "hello rest webservice from Post handler";
	}
	@DeleteMapping("/hello")
	public String sayHelloRestforDelete() {
		return "hello rest webservice from Delete handler";
	}
	@RequestMapping("/hello")
	public String sayHelloRestForRequest() {
		return "hello rest webservice from request mapping handler";
	}

}
