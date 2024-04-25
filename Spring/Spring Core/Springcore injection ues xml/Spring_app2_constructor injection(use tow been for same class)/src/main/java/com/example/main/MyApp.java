package com.example.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.interfac.Coach;

public class MyApp {
	public static void main (String [] args) {
		//Creat context
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
	
	//get bean by id
		
		Coach myCoach=context.getBean("myCoach",Coach.class);
		
		Coach myCoach1=context.getBean("myCoach1",Coach.class);
	//object call	
		System.out.println(myCoach.getDailyWork());
		System.out.println(myCoach.getDailyFortun());
		
		System.out.println(myCoach1.getDailyFortun());
		
	}
	
	

}
