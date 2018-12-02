package org.vexelon.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.vexelon.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLogginAspect {
	
	@Before("org.vexelon.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n====>>> Executiing @Before advice on method()");

		// display method signature
		MethodSignature methoSig = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method: " + methoSig);
		
		// display method arguments
		
		// get args
		Object[] args = theJoinPoint.getArgs();
		
		// loop trough args
		for(Object tempArg: args) {
			System.out.println(tempArg);
			
			if(tempArg instanceof Account) {
				
				// downcast and print Account specific stuff
				Account theAccout = (Account) tempArg;
				System.out.println("accout name: " + theAccout.getName());
				System.out.println("accout level: " + theAccout.getLevel());
			}
		}
		
	}
	
}