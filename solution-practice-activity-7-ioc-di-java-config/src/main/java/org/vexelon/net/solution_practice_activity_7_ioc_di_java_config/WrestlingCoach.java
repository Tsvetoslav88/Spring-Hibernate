package org.vexelon.net.solution_practice_activity_7_ioc_di_java_config;

import org.springframework.beans.factory.annotation.Autowired;

public class WrestlingCoach implements Coach {

	//If we use Fild injection
	@Autowired
	FortuneService fortuneService;
	

	public WrestlingCoach() {
		System.out.println("Inside Wrestling Coach constructor");
	}

	//If we use Construcotr injection
	//	@Autowired
//	public WrestlingCoach(FortuneService theFortuneService) {
//		System.out.println("Inside Wrestling Coach constructor");
//		this.fortuneService = theFortuneService;
//	}
	
	@Override
	public String getDailyWorkout() {
		return "Do exercise two time per day";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
