package org.vexelon.net.spring_demo_annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {
	public static void main(String[] args) {
		// load spring ocnfig file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve bean from spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		
		// check if they are the same object
		boolean result = (theCoach == alphaCoach);
		
		// print out the result
		System.out.println("\nPoint to the same object: " + result);
		
		System.out.println("\nMemori location for theCoach: " + theCoach);
		
		System.out.println("\nMemori location for alphaCoach: " + alphaCoach);
		
		//close context
		context.close();
	}
}
