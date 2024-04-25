package com.example.impl;

import com.example.interfac.Coach;
import com.example.interfac.Fortun;

public class FootballCoach implements Coach{
	
Fortun object;	
//	
//	public FootballCoach(Fortun object) {
//		
//        this.object=object;
//	}


	public String getDailyWork() {
	return	"Football";
		
	}


	public void setObject(Fortun object) {
		this.object = object;
	}

	@Override
	public String getDailyFortun() {
		// TODO Auto-generated method stub
		return object.fortune();
	}

	
}
