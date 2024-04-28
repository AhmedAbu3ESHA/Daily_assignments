package com.example.hello.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hello.entities.Address;
import com.example.hello.entities.ShippingObj;

@RestController
@RequestMapping("/shipping")
public class ShippingRestController {
	
	private ShippingObj shippingData;
	
	// add shipping data
	
	// get shipping data
	
	@GetMapping
	public ShippingObj getShipping() {

		ShippingObj obj = new ShippingObj("sh1000", new Address("Egypt","Cairo","Elyassmin"), 1000, false);
		return obj;
	
	}
	
	@PostMapping
	public ShippingObj insertShippingData(@RequestBody ShippingObj obj) {
		System.out.println("ShipingObj : "+obj);
		//return "your object has been inserted successfully";
		return obj;
	}
	
	

}
