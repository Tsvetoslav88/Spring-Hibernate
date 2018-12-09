package org.vexelon.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.vexelon.aopdemo.dao.AccountDAO;
import org.vexelon.aopdemo.dao.MembershipDAO;
import org.vexelon.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {
		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get bean from spring container
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		System.out.println("\nMain program: AroundDemoApp");
		
		System.out.println("Calling getFortune");
		String data = theFortuneService.getFortune();
		
		System.out.println("\nMy fortune is: " + data);
		
		System.out.println("Finished!");
		
		//close the context
		context.close();
	}

}
