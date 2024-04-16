package com.example.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.interfac.Coach;
import com.example.interfac.Fortun;
@Component("myCoach")
public class FootballCoach implements Coach{


Fortun object;	

@Autowired
	public FootballCoach(@Qualifier("sad_Fortune")Fortun object) {
		System.out.println("constructor");
      this.object=object;
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
