package com.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;

//define a default constructor
	public CricketCoach() {
		//System.out.println(">> CricketCoach: inside default constructor");
	}
	/*
	 * // define a setter method
	 * 
	 * @Autowired public void setFortuneService(FortuneService theFortuneService) {
	 * System.out.println(">> CricketCoach: inside setFortuneService() method");
	 * fortuneService = theFortuneService; }
	 * 
	 * @Autowired public CricketCoach(FortuneService theFortuneService) {
	 * fortuneService=theFortuneService; }
	 */

	@Override
	public String getDailyWorkout() {
		return "pratice your fastbowling for 30m min in the morning";
	}

	@Override
	public String getDailyFoprtune() {
		return fortuneService.getFortune();
	}

}
