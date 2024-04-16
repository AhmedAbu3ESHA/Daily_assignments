package com.example.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.interfac.Coach;
import com.example.interfac.Fortun;
@Component("myCoach")
public class FootballCoach implements Coach{

@Autowired
@Qualifier("happy_Fortune")
Fortun object;	

@Value ("${coash.name}")
private String name;

//	public FootballCoach(Fortun object) {
//		System.out.println("constructor");
//      this.object=object;
//	}

	public String getName() {
	return name;
}



public void setName(String name) {
	this.name = name;
}



	public String getDailyWork() {
	return	"Football";
		
	}



	@Override
	public String getDailyFortun() {
		// TODO Auto-generated method stub
		return object.fortune();
	}

	
}
