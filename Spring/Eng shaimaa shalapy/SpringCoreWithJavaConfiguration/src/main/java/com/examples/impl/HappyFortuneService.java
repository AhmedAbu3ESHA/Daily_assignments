package com.examples.impl;

import org.springframework.stereotype.Component;

import com.examples.interfaces.FortuneService;

@Component
public class HappyFortuneService implements FortuneService {

	public String getDailyFortune() {
		return "This is a very nice day";
	}
	

}
