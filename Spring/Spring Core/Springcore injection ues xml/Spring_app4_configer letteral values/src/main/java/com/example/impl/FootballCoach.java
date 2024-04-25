package com.example.impl;

import com.example.interfac.Coach;
import com.example.interfac.Fortun;

public class FootballCoach implements Coach{
	//just because we have to methods in interface must be implemented (useless)
Fortun object;	

private String coachName;
//	
//	public FootballCoach(Fortun object) {
//		
//        this.object=object;
//	}


	public String getCoachName() {
	return coachName;
}


public void setCoachName(String coachName) {
	this.coachName = coachName;
}


	public String getDailyWork() {
	return	"Football";
		
	}


	public void setObject(Fortun object) {
		this.object = object;
	}

	//just because we have to methods in interface must be implemented (useless)
	@Override
	public String getDailyFortun() {
		// TODO Auto-generated method stub
		return object.fortune();
	}

	
}
