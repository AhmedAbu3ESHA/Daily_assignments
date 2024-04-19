package com.examples.impl;

import com.examples.interfaces.FortuneService;

public class SadFortuneService implements FortuneService {

	@Override
	public String getDailyFortune() {
		return "It is not your day";
	}

}
