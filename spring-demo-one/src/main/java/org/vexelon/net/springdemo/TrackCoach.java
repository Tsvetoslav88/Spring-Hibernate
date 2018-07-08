package org.vexelon.net.springdemo;

public class TrackCoach implements Coach {

	// define a private field for the dependency
	private FortuneService fortuneService;
	
	// define a constructor for dependency injection
	public TrackCoach(FortuneService theFortuneService) {
		super();
		this.fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		// use my fortune service to get a fortune
		return "Just do it: " + fortuneService.getFortune();
	}

}
