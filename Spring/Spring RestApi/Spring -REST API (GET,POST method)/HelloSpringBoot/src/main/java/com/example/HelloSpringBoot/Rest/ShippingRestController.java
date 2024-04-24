package com.example.HelloSpringBoot.Rest;

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
		
		ShippingObj shippingObj =new ShippingObj("SH1",new Address("egypt","cairo","hh1"),1000,false);
		
		return shippingObj;
	}
	
	//post shipping data
	@PostMapping("/")
	public  String insertShippingData(@RequestBody ShippingObj postshippingObj) {
		
		System.out.print("post shipping Obj :" + postshippingObj);
		return "Done";
		
		
	}
	
	
	
}
