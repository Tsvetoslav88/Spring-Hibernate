package org.vexelon.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLogginAspect {

	// setup logger
	private Logger myLogger = Logger.getLogger(CRMLogginAspect.class.getName());
	
	// setup poincut decplaration
	@Pointcut("execution(* org.vexelon.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}

	@Pointcut("execution(* org.vexelon.springdemo.service.*.*(..))")
	private void forServicePackage() {}

	@Pointcut("execution(* org.vexelon.springdemo.dao.*.*(..))")
	private void forDaoPackage() {}

	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	// add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		// display method we are calling
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("=====>>> in @Before: calling method: " + theMethod);
		
		// display the arguments to the method
		
		// get the arguments
		Object[] args = theJoinPoint.getArgs();
		
		// loop through and display the arguments
		for (Object tempArg : args) {
			myLogger.info("====>>> arguments: " + tempArg);
		}
	}
	
	
	// add @AfterReturning advice
	@AfterReturning(
			pointcut="forAppFlow()",
			returning="theResult")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		
		// display method we are returning from
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("=====>>> in @AfterReturnig: from method: " + theMethod);
		
		// display data returned 
		myLogger.info("===>> result: " + theResult);
		
		
	}
}
