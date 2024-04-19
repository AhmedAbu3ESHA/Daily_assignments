package com.examples.impl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.examples.interfaces.Coach;
import com.examples.interfaces.FortuneService;

@Component("myCoach")
public class FootballCoach implements Coach {
	
	// dependency
//	@Autowired
//	@Qualifier("sadFortuneService")
	private FortuneService fortuneService;
	
	@Value("${coach.name}")
	private String coachName;
	
	@Value("${coach.email}")
	private String coachEmail;
	
	@Autowired
	public FootballCoach(@Qualifier("sadFortuneService") FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	public FootballCoach() {
//		System.out.println("[FootballCoach] inside constructor");
	}
	
	@PostConstruct
	public void init() {
//		System.out.println("[FootballCoach] inside init method");
	}
	
	@PreDestroy
	public void destroy() {
//		System.out.println("[FootballCoach] inside destroy method");
	}

	public String getDailyWork() {
		return "practice Football for 2 hours daily";
	}

	
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
