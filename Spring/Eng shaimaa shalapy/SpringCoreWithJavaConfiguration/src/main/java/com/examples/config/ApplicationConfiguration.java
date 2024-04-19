package com.examples.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.examples.impl.SadFortuneService;
import com.examples.impl.SwimmingCoach;

@Configuration
@ComponentScan("com.examples")
@PropertySource("classpath:values.properties")
public class ApplicationConfiguration {
	
	
//	@Bean
//	public SwimmingCoach sCoach() {
//		return new SwimmingCoach(sadFortuneService());
//	}
	
	@Bean
	public SwimmingCoach sCoach() {
		
		SwimmingCoach sCoach = new SwimmingCoach();
		sCoach.setFortuneService(sadFortuneService());
		return sCoach;
	}
	
	@Bean 
	public SadFortuneService sadFortuneService() {
		return new SadFortuneService();
	}

}
