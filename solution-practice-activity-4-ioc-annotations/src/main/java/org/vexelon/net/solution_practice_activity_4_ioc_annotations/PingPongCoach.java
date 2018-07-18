package org.vexelon.net.solution_practice_activity_4_ioc_annotations;

import org.springframework.stereotype.Component;

@Component
public class PingPongCoach implements Coach {

	// define a default constructor
	public PingPongCoach() {
		System.out.println(">> PingPongCoach: inside default constructor");
	}

	@Override
	public String getDailyWorkout() {
		return "Practice your pingpong drop shot";
	}
}
