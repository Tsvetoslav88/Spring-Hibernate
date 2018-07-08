package org.vexelon.net.springdemo;

public class MyApp {

	public static void main(String[] args) {
		// create the object
		Coach theCoach = new GolfCoach();
		
		// use the object
		System.out.println(theCoach.getDailyWorkout());

	}

}
