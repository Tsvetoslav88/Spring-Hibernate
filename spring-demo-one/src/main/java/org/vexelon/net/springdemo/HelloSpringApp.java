package org.vexelon.net.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		// Load the Spring configuration file
		ClassPathXmlApplicationContext contex = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Retrieve the bean from spring container
		Coach theCoach = contex.getBean("myCoach", Coach.class);//BeanId, Interface
		
		// Call the methods on the bean 
		System.out.println(theCoach.getDailyWorkout());
		
		// let's call our new method for fortunes
		System.out.println(theCoach.getDailyFortune());
		
		// Close the context 
		contex.close();

	}

}
