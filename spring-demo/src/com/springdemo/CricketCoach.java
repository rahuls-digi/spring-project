package com.springdemo;

public class CricketCoach implements Coach {

	private FortuneService fortuneService;

	//add new feilds for emailAddress and team
	private String emailAddress;
	
	private String team;
	
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach :inside setter method- setemailAddress");
		this.emailAddress = emailAddress;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		System.out.println("CricketCoach :inside setter method- setTeam");
		this.team = team;
	}
	// create no-arg constructor
	public CricketCoach() {
		System.out.println("CricketCoach : inside no arg");
	}
    //setter method
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach :inside setter method- fortuneService");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "do shadow pratic to improve your footwork";
	}

	@Override
	public String getDailyFortune() {
//use fortuneService to get a fortune
		return fortuneService.getFortune();
	}
}
