package com.examples.impl;

import com.examples.interfaces.Coach;
import com.examples.interfaces.FortuneService;

public class SwimmingCoach implements Coach {
	
	private FortuneService fortuneService;
	private String coachName;
	private String coachEmail;
	
//	public SwimmingCoach(FortuneService service) {
//		this.fortuneService = service;
//	}

	public String getDailyWork() {
		return "swim for 30 min every morning";
	}

	
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getDailyFortune();
	}

	public FortuneService getFortuneService() {
		return fortuneService;
	}

	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	public String getCoachName() {
		return coachName;
	}

	public void setCoachName(String coachName) {
		this.coachName = coachName;
	}

	public String getCoachEmail() {
		return coachEmail;
	}

	public void setCoachEmail(String coachEmail) {
		this.coachEmail = coachEmail;
	}
	
	

}
