package com.example.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.impl.FootballCoach;
import com.example.interfac.Coach;

public class MyApp {
	public static void main (String [] args) {
		//Creat context
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
	
	//get bean by id
		
		Coach myCoach=context.getBean("myCoach",Coach.class);
	//object call	
		if (myCoach instanceof Coach) {
	           FootballCoach fcoach = (FootballCoach) myCoach; //concret type 
	            System.out.println(fcoach.getCoachName());
	       
		}
	}
	
	

}
