package com.springdemo;

public class TrackCoach implements Coach {


	private FortuneService fortuneService;
	
	public TrackCoach() {
		
	}
	public TrackCoach (FortuneService  theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		
		return "run hard 5km daily in the morning";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
		
	}

	// add an init method
	public void doMyStartupStuff() {
		System.out.println("TrackCoach : inside method domystartupstuff");
	}
	
	//add an destroy method
	public void doMyCleanupStuff() {
		System.out.println("TrackCoach : inside method domyCleanupstuff");
	}
	
	
	
}
