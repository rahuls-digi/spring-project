package com.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	
	//create an array of strings
	private String[] data = {
			"beware of the wolf in the sheeps clothing",
			"Diligence is the mother of good luck",
			"The journey is the reward"
			
	};
	// create a random number generator
	private Random myRandom = new Random();
	
	@Override
	public String getFortune() {
		int index = myRandom.nextInt(data.length);
		String theFortune = data[index];
		return theFortune;
	}

}
