package com.model;

public class Department {
	
	private String name;
	private int department_id;
	
	public Department(int id,String name) {
		this.department_id=id;
		this.name=name;
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	
	

}
