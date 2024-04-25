package com.example.impl;

import org.springframework.stereotype.Component;

import com.example.interfac.Fortun;
@Component
public class Sad_Fortune implements Fortun {

	@Override
	public String fortune() {
		// TODO Auto-generated method stub
		return	"sad";
	}
}
