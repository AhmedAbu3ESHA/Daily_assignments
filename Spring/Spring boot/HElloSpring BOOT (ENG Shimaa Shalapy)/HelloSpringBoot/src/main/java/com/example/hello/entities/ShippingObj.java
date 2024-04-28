package com.example.hello.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ShippingObj {
	
	private String shippingId;
	private Address address;
	private int code;
	private boolean active;
	
	public ShippingObj() {
		
	}
	
	
	public ShippingObj(String shippingId, Address address, int code, boolean active) {
		super();
		this.shippingId = shippingId;
		this.address = address;
		this.code = code;
		this.active = active;
	}
	public String getShippingId() {
		return shippingId;
	}
	public void setShippingId(String shippingId) {
		this.shippingId = shippingId;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}


	@Override
	public String toString() {
		return "ShippingObj [shippingId=" + shippingId + ", address=" + address + ", code=" + code + ", active="
				+ active + "]";
	}
	
	

}
