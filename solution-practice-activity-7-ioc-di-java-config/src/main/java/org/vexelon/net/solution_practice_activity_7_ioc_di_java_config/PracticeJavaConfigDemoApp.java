package org.vexelon.net.solution_practice_activity_7_ioc_di_java_config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PracticeJavaConfigDemoApp {

	public static void main(String[] args) {
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PracticeSportConfig.class);
		
		// get the bean from spring container
		Coach theCoach = context.getBean("wrestlingCoach", WrestlingCoach.class);
		
		// call a method on the bean
		System.out.println(theCoach.getDailyFortune());
		
		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		// close the context
		context.close();
		
	}

}
