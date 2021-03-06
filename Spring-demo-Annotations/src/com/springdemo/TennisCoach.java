package com.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("prototype")
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;

	// define a default constructor
	public TennisCoach() {
		System.out.println(">> TennisCoach: inside default constructor");
	}
   
	/*// define a setter method
	@Autowired
	public void setFortuneService(FortuneService theFortuneService) {
		System.out.println(">> TennisCoach: inside setFortuneService() method");
		fortuneService = theFortuneService;
	}

	
	 * @Autowired public TennisCoach(FortuneService theFortuneService) {
	 * fortuneService=theFortuneService; }
	 */

	@Override
	public String getDailyWorkout() {
		return "pratice your backhand volley";
	}

	@Override
	public String getDailyFoprtune() {
		return fortuneService.getFortune();
	}

}
