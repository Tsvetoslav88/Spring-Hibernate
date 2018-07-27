package org.vexelon.net.solution_practice_activity_7_ioc_di_java_config;

public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is your lucky day";
	}

}
