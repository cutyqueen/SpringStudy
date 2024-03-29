package com.itwillbs.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 *  advice 객체
 */
public class LoggingAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// 보조기능을 구현
		System.out.println("1111111111111"); // 보조기능
		
		Object obj = invocation.proceed();  // 주기능
		
		System.out.println("2222222222222"); // 보조기능
		return obj;
	}
	
}
