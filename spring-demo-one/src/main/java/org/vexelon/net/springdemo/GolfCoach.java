package org.vexelon.net.springdemo;

public class GolfCoach implements Coach {

	// define a private field for the dependency
	private FortuneService fortuneService;

	public GolfCoach() {
		super();
	}
	
	// define a constructor for dependency injection
	public GolfCoach(FortuneService theFortuneService) {
		super();
		this.fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice your putting skills for 2 hours today";
	}

	@Override
	public String getDailyFortune() {
		// use my fortune service to get a fortune
		return "Just do it: " + fortuneService.getFortune();
	}

}
