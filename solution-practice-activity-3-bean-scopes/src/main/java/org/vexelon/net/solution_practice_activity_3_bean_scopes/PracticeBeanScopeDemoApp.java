package org.vexelon.net.solution_practice_activity_3_bean_scopes;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PracticeBeanScopeDemoApp {
	public static void main(String[] args) {

		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// retrieve bean from spring container
		Coach firstCoach = context.getBean("myGolfCoach", GolfCoach.class);

		Coach secondCoach = context.getBean("myGolfCoach", GolfCoach.class);

		// check if they are the same
		boolean result = (firstCoach == secondCoach);

		// print out the results
		System.out.println("\nPointing to the same object: " + result);

		System.out.println("\nMemory location for theCoach: " + firstCoach);

		System.out.println("\nMemory location for alphaCoach: " + secondCoach + "\n");

		// close the context
		context.close();
	}
}
