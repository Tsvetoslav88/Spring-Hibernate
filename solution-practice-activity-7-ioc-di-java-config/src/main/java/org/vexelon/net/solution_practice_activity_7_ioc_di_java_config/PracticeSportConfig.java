package org.vexelon.net.solution_practice_activity_7_ioc_di_java_config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PracticeSportConfig {
	
	// define bean for our happy fortune service
	@Bean
	public FortuneService happyFortuneService() {
		return new HappyFortuneService();
	}
	
	// define bean for our swim coach AND inject dependency
	@Bean
	public Coach wrestlingCoach(){
		
		// Java configuration if we use Construcotr injection
//		WrestlingCoach myWrestlingCoach = new WrestlingCoach(happyFortuneService());
		
		// Java configuration if we use Filed
		WrestlingCoach myWrestlingCoach = new WrestlingCoach();
		return myWrestlingCoach;
	}
	
	
	
}
