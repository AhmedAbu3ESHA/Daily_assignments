package com.examples.impl;

import org.springframework.stereotype.Component;

import com.examples.interfaces.FortuneService;

@Component
public class SadFortuneService implements FortuneService {


	public String getDailyFortune() {
		return "It is not your day";
	}

}
