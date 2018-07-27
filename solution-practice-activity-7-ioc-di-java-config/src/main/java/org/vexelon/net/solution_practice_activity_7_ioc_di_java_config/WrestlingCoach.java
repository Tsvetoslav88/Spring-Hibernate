package org.vexelon.net.solution_practice_activity_7_ioc_di_java_config;

import org.springframework.beans.factory.annotation.Autowired;

public class WrestlingCoach implements Coach {

	FortuneService fortuneService;
	
	@Autowired
	public WrestlingCoach(FortuneService theFortuneService) {
		System.out.println("Inside Wrestling Coach constructor");
		this.fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Do exercise two time per day";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
