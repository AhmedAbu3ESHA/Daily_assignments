package com.examples.impl;

import com.examples.interfaces.FortuneService;

public class HappyFortuneService implements FortuneService {

	@Override
	public String getDailyFortune() {
		return "This is a very nice day";
	}

}
