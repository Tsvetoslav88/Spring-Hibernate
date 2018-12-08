package org.vexelon.aopdemo.aspect;

import java.util.List;
import java.util.stream.Collectors;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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
	
	@After("execution(* org.vexelon.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountAdvice(JoinPoint theJoinPoint) {
		//print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>>>> Executing @After (finally) on method: " + method);
		
		
	}
	
	@AfterThrowing(pointcut="execution(* org.vexelon.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theExc")
	public void afterThrowingFindAccountAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		//print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>>>> Executing @AfterThrowing on method: " + method);
				
		//log the exception
		System.out.println("\n=====>>>> The exception is: " + theExc);
	}
	
	@AfterReturning(
			pointcut="execution(* org.vexelon.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccoutsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>>>> Executing @AfterReturning on method: " + method);
		
		// print out the results of the method call
		System.out.println("\n=====>>>> result is: " + result);
		
		
		// let's post-process the data ...
		
		// covert the account names to uppercase
		result.stream().forEach(name -> name.setName(name.getName().toUpperCase()));
		
		System.out.println("\n=====>>>> result is: " + result);
	}
	
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