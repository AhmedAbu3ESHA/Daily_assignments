package com.example.HelloSpringBoot.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoggingAspect {
	
	//adding this bevore save in data base
	@Before("execution(* save(*))")
	public void logBeforeAddObjectToDB() {
		
		System.out.println("Aspect output");
	}

}
