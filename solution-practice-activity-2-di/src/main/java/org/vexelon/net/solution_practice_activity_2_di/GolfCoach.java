package org.vexelon.net.solution_practice_activity_2_di;

public class GolfCoach implements Coach {
	
	
	private FortuneService fortuneService;
	
	
	
	public GolfCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice your putting skills for 2 hours today";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
