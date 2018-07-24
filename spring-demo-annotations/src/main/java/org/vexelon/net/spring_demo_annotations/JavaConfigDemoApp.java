package org.vexelon.net.spring_demo_annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		// get bean from spring container
//		TennisCoach theCoach = context.getBean("tennisCoach", TennisCoach.class);
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		// call method to get the daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		// call method which read properties data
//		System.out.println(theCoach.getPropertiesField());
		
		// close the context
		context.close();
		
	}

}
