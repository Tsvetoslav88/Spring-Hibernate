package org.vexelon.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLogginAspect {
	
	
	@Pointcut("execution(* org.vexelon.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	//Create pointcut for getter methods
	@Pointcut("execution(* org.vexelon.aopdemo.dao.*.get*(..))")
	private void getter() {}
	
	//Create pointcut for setter methods
	@Pointcut("execution(* org.vexelon.aopdemo.dao.*.set*(..))")
	private void setter() {}
	
	//Create point: include package...exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAccountAdvice() {
		System.out.println("\n====>>> Executiing @Before advice on method()");
	}

	@Before("forDaoPackageNoGetterSetter()")
	public void performApiAnalytics() {
		System.out.println("\n====>>> Perform API analytics");
	}
	
}