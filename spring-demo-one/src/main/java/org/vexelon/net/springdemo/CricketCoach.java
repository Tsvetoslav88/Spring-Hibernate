package org.vexelon.net.springdemo;

public class CricketCoach implements Coach {

	private FortuneService fortuneService;
	
	// create no-argument constructor
	public  CricketCoach() {
		System.out.println("Cricket Coach: inside no-arg constructor");
	}
	
	// our setter method
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Cricket Coach: inside setter method - setFortuneService");
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practing fast bowling for 15 minutes";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
