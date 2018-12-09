package org.vexelon.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.vexelon.aopdemo.Account;
import org.vexelon.aopdemo.AroundWithLoggerDemoApp;

@Aspect
@Component
@Order(2)
public class MyDemoLogginAspect {
	
	private static Logger myLogger = Logger.getLogger(MyDemoLogginAspect.class.getName());

	
	@Around("execution(* org.vexelon.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable{
		
		//print out the method we are advaising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====>>>> Executing @Around on method: " + method);
		
		//get begin timestamp
		long begin = System.currentTimeMillis();
		
		//execute the method
		Object result = null;
		try {
			result = theProceedingJoinPoint.proceed();
		} catch (Exception e) {
			// log the exception
			myLogger.warning(e.getMessage());
			
			// rethrow exception
			throw e;
		}
		
		//get end timestamp
		long end = System.currentTimeMillis();
		
		//compute the duration and display it
		long duration = end - begin;
		myLogger.info("\n===> Duration: " + duration/1000.0 + " seconds");
		
		return result;
	}
	
	@After("execution(* org.vexelon.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountAdvice(JoinPoint theJoinPoint) {
		//print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====>>>> Executing @After (finally) on method: " + method);
		
		
	}
	
	@AfterThrowing(pointcut="execution(* org.vexelon.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theExc")
	public void afterThrowingFindAccountAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		//print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====>>>> Executing @AfterThrowing on method: " + method);
				
		//log the exception
		myLogger.info("\n=====>>>> The exception is: " + theExc);
	}
	
	@AfterReturning(
			pointcut="execution(* org.vexelon.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccoutsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====>>>> Executing @AfterReturning on method: " + method);
		
		// print out the results of the method call
		myLogger.info("\n=====>>>> result is: " + result);
		
		
		// let's post-process the data ...
		
		// covert the account names to uppercase
		result.stream().forEach(name -> name.setName(name.getName().toUpperCase()));
		
		myLogger.info("\n=====>>>> result is: " + result);
	}
	
	@Before("org.vexelon.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAccountAdvice(JoinPoint theJoinPoint) {
		myLogger.info("\n====>>> Executiing @Before advice on method()");

		// display method signature
		MethodSignature methoSig = (MethodSignature) theJoinPoint.getSignature();
		myLogger.info("Method: " + methoSig);
		
		// display method arguments
		
		// get args
		Object[] args = theJoinPoint.getArgs();
		
		// loop trough args
		for(Object tempArg: args) {
			myLogger.info(tempArg.toString());
			
			if(tempArg instanceof Account) {
				
				// downcast and print Account specific stuff
				Account theAccout = (Account) tempArg;
				myLogger.info("accout name: " + theAccout.getName());
				myLogger.info("accout level: " + theAccout.getLevel());
			}
		}
		
	}
	
}