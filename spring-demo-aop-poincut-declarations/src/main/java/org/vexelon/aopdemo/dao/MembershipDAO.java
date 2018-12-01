package org.vexelon.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public void addAccount() {
		System.out.println(getClass() + " DOING STUFF: ADDOMG A MEMBERSHIP ACCOUNTS");
	}
	
	public void goToSleep() {
		System.out.println(getClass() + " I'm going to sleep now...");
	}
}
