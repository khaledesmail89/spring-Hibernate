package com.luv2code.luv2code;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	
	private String[] data = {
			"Beware of the wolf in sheep's clothing",
			"Diligence is the mother of good luck",
			"the journey is the reward"
	};
	
	private Random random = new Random(); 
	
	public String getFortune() {
		int index = random.nextInt(data.length);
String theFortune = data[index];
		return theFortune;
	}

}
