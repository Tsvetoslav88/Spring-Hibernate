package org.vexelon.net.solution_practice_activity_3_bean_scopes;

import java.util.Random;

public class RandomFortuneService implements FortuneService {

	// create an array of strings
	private String[] data = { "Beware of the wolf in sheep's clothing", "Diligence is the mother of good luck",
			"The journey is the reward" };
	
	// create random number generator
	Random myRandom = new Random();

	@Override
	public String getFortune() {
		// pick a random string from the array
		int index = myRandom.nextInt(data.length);
		
		String theFortune = data[index];
		
		return theFortune;
	}

}
