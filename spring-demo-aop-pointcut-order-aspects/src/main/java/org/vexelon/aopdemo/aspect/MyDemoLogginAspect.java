package org.vexelon.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLogginAspect {
	
	@Before("org.vexelon.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAccountAdvice() {
		System.out.println("\n====>>> Executiing @Before advice on method()");
	}
	
}