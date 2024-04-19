package com.examples.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.examples.impl.FootballCoach;
import com.examples.interfaces.Coach;

public class MyApp {

	public static void main(String[] args) {
		// create context 
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get bean by id 
		Coach myCoach1 = context.getBean("myCoach",Coach.class);
		
//		Coach myCoach2 = context.getBean("myCoach",Coach.class);
//		
//		Coach myCoach3 = context.getBean("myCoach",Coach.class);
		
		System.out.println("myCoach1 : "+myCoach1);
//		System.out.println("myCoach2 : "+myCoach2);
//		System.out.println("myCoach3 : "+myCoach3);
		
		// invoke bean business 
//		System.out.println(myCoach.getDailyWork());
//		System.out.println(myCoach.getDailyFortune());
//		
//		
//		
//		if(myCoach instanceof FootballCoach) {
//			FootballCoach fCoach = (FootballCoach) myCoach;
//			System.out.println(fCoach.getCoachEmail());
//			System.out.println(fCoach.getCoachName());
//		}
//		
		
		// close context 
		context.close();

	}

}
