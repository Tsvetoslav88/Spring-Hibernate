package org.vexelon.net.spring_demo_annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	
	//Field DI
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	public TennisCoach() {
		System.out.println(">> Tennis Coach: inside default construcotr");
	}
	
	// Constructor injection
//	@Autowired
//	public TennisCoach(FortuneService theFortuneService) {
//		super();
//		this.fortuneService = theFortuneService;
//	}


	// Setter injection
//	@Autowired
//	public void setFortuneService(FortuneService theFortuneService) {
//		System.out.println(">> Tennis Coach: inside setFortuneService() method");
//		this.fortuneService = theFortuneService;
//	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}


	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	public String getPropertiesField() {
		return "Tennis Coach email is: " + email + " and is part of team: " + team;
	}

	
}
