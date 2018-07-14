package org.vexelon.net.solution_practice_activity_2_di;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PracticeHelloSpringApp {
	public static void main(String[] args) {
		
		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve bean from spring container
		Coach theCoach = context.getBean("myGolfCoach", GolfCoach.class);
		
		// call method on the bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		// close the context
		context.close();
	}
}
