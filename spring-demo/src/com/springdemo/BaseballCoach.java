package com.springdemo;

public class BaseballCoach implements Coach {

	//define a private feild for dependency injection
	private FortuneService fortuneService;
	
	//define a constructor for dependency injection
	public BaseballCoach (FortuneService  theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "spend 30 min on batting pratice";
	}

	@Override
	public String getDailyFortune() {
//use fortuneService to get a fortune
		return fortuneService.getFortune();
	}
}
