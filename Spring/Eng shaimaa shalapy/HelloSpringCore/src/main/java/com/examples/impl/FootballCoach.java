package com.examples.impl;

import com.examples.interfaces.Coach;
import com.examples.interfaces.FortuneService;

public class FootballCoach implements Coach {
	
	// dependency
	private FortuneService fortuneService;
	private String coachName;
	private String coachEmail;
	
//	public FootballCoach(FortuneService fortuneService) {
//		this.fortuneService = fortuneService;
//	}
	
	public FootballCoach() {
		System.out.println("[FootballCoach] inside constructor");
	}
	
	public void init() {
		System.out.println("[FootballCoach] inside init method");
	}
	
	public void destroy() {
		System.out.println("[FootballCoach] inside destroy method");
	}

	public String getDailyWork() {
		return "practice Football for 2 hours daily";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getDailyFortune();
	}

	public FortuneService getFortuneService() {
		return fortuneService;
	}

	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("[FootballCoach] inside setter of fortune service - dependency injection");
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
