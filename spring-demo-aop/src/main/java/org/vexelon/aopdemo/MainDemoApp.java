package org.vexelon.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.vexelon.aopdemo.dao.AccountDAO;
import org.vexelon.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// get member bean from spring container
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		//call the business method
		theAccountDAO.addAccount();
		
		//call the membership business method
		theMembershipDAO.addAccount();
		
		//close the context
		context.close();
	}

}
