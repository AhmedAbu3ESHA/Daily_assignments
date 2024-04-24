package com.example.HelloSpringBoot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.HelloSpringBoot.Entites.Address;
import com.example.HelloSpringBoot.Entites.ShippingObj;

@RestController
@RequestMapping("/shipping")
public class ShippingRestController {

	private ShippingObj shippingData;
	
	//get shipping data
	@GetMapping("/")
	public ShippingObj getShipping() {
	
		  ShippingObj shippingObj= new ShippingObj ("dd",new Address("lybia","london","Agt"),2000,false);
		return shippingObj;
	}
	
	//post shipping data
	@PostMapping("/")
	public  String insertShippingData(@RequestBody ShippingObj postshippingObj) {
		
		System.out.print("post shipping Obj :" + postshippingObj);
		return "Done";
		
		
	}
	
	
	
}
